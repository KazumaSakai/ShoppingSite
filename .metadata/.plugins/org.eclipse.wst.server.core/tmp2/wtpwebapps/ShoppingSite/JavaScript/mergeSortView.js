class SorterViewObject
{
	constructor()
	{
		this.value;
		this.isMove = true;
		this.y = 0;
		this.index = 0;
	}
	
	render(context, w, h)
    {
        context.beginPath();
        context.fillStyle = this.isMove ? 'rgb(70, 70, 70)' : 'rgb(0, 0, 0)';
        context.rect(1 + (this.index * 11), h - this.value - (this.y * 10),
					 10, this.value);
        context.fill();
    }
	
	static CraeteArray(length)
	{
		var ary = new Array(length);
		for(var i = 0; i < length; i++)
		{
			ary[i] = new SorterViewObject();
		}
		return ary;
	}
	
}

class Sorter
{
    static MargeSort (ary, begin, end)
    {
        var length = (end - begin);
        if(length == 1) return;
        if(length == 2)
        {
            if(ary[begin] > ary[begin + 1])
            {
                Sorter.SwitchAry(ary, begin, begin + 1);
            }
            return;
        }

        var center = begin + Math.floor(length / 2);
        Sorter.MargeSort(ary, begin, center);
        Sorter.MargeSort(ary, center, end);

        var leftLength = center - begin;
        var rightLength = end - center;

        var leftIndex = begin;
        var rightIndex = center;

        var tmpAry = new Array(length);
        var index = 0;

        while(leftLength > 0 || rightLength > 0)
        {
            if(leftLength > 0 && rightLength > 0)
            {
                if(ary[leftIndex] < ary[rightIndex])
                {
                    tmpAry[index] = ary[leftIndex];
                    index++;
                    leftIndex++;
                    leftLength--;
                }
                else
                {
                    tmpAry[index] = ary[rightIndex];
                    index++;
                    rightIndex++;
                    rightLength--;
                }
                continue;
            }

            if(leftLength > 0)
            {
                tmpAry[index] = ary[leftIndex];
                index++;
                leftIndex++;
                leftLength--;
            }
            else
            {
                tmpAry[index] = ary[rightIndex];
                index++;
                rightIndex++;
                rightLength--;
            }
        }

        Sorter.ReplaceAry(ary, tmpAry, begin, end);
    }
        
    static CreateRandomArray (aryLength, height)
    {
        var ary = new Array(aryLength);

        for(var i = 0; i < ary.length; i++)
        {
            ary[i] = Math.floor( Math.random() * height );
        }

        return ary;
    }
    
    static SwitchAry (ary, a, b)
    {
        var tmp = ary[a];
        ary[a] = ary[b];
        ary[b] = tmp;
    }
    
    static ReplaceAry (baseAry, newAry, begin, end)
    {
        for(var i = begin; i < end; i++)
        {
            baseAry[i] = newAry[i - begin];
        }
    }
	
	//	マージソートをgeneratorでする
	static GeneratorMergeSort(ary, begin, end)
	{
		function* generator(ary, begin, end)
		{
			//	長さを計測
			var length = (end - begin);
			
			//	長さが１なら終了
			if(length == 1) return;
			
			//	長さが２なら入れ替えて終了
			if(length == 2)
			{
				//	左側のほうが小さければなにもしない
				if(ary[begin] < ary[begin + 1]) return;
				
				//	左側のほうが大きければ入れ替え
				Sorter.SwitchAry(ary, begin, begin + 1);
				
				var obj = {};
				obj.isSwitch = true;
				obj.from = begin;
				obj.to = begin + 1;
				
				yield obj;
				return;
			}

			//	中央の場所を計算
			var center = begin + Math.floor(length / 2);
			
			//	左側をマージソート
			var g1 = Sorter.GeneratorMergeSort(ary, begin, center);
			var r1 = g1.next();
			while(!r1.done)
			{
				yield r1.value;
				r1 = g1.next();
			}
			
			//	右側をマージソート
			var g2 = Sorter.GeneratorMergeSort(ary, center, end);
			var r2 = g2.next();
			while(!r2.done)
			{
				yield r2.value;
				r2 = g2.next();
			}

			//	左の長さ
			var leftLength = center - begin;
			//	右の長さ
			var rightLength = end - center;

			//	次に見るべき左の値
			var leftIndex = begin;
			//	次に見るべき右の値
			var rightIndex = center;

			//	一時的に値を保存しておく配列
			var tmpAry = new Array(length);
			//	その配列に次に追加する場所
			var index = 0;

			//	どちらも無くなるまで回す
			while(leftLength > 0 || rightLength > 0)
			{
				//	どちらもある場合
				if(leftLength > 0 && rightLength > 0)
				{
					//	左のほうが値が小さい場合
					if(ary[leftIndex] < ary[rightIndex])
					{
						tmpAry[index] = ary[leftIndex];
						index++;
						leftIndex++;
						leftLength--;
					}
					//	右のほうが値が小さい場合
					else
					{
						tmpAry[index] = ary[rightIndex];
						index++;
						rightIndex++;
						rightLength--;
					}
					
					continue;
				}

				//	左にしか無い場合
				if(leftLength > 0)
				{
					tmpAry[index] = ary[leftIndex];
					index++;
					leftIndex++;
					leftLength--;
				}
				//	右にしか無い場合
				else
				{
					tmpAry[index] = ary[rightIndex];
					index++;
					rightIndex++;
					rightLength--;
				}
			}

			//	一時的に保存していた値を実際に代入する
			Sorter.ReplaceAry(ary, tmpAry, begin, end);
			
			//	一つ一つ、値を変更していく
			for(var i = begin; i < end; i++)
			{
				var obj = {};
				obj.isSwitch = false;
				obj.index = i;
				obj.value = ary[i];
				
				yield obj;
			}
		}
		
		return generator(ary, begin, end);
	}
}

class ArrayRect
{
    constructor()
    {
        this.valueAry = Sorter.CreateRandomArray(60, 400);
		this.renderAry = SorterViewObject.CraeteArray(60);
		
		this.generator = Sorter.GeneratorMergeSort(this.valueAry, 0, this.valueAry.length);
        for(var i = 0; i < this.valueAry.length; i++)
        {
            this.renderAry[i].value = this.valueAry[i];
            this.renderAry[i].index = i;
        }
		
		this.inAction = false;
		this.done = false;
    }
    
    update()
    {
		if(!this.done && this.inAction)
		{
			this.sort();
		}
    }
    
    render(context, w, h)
    {
        for(var i = 0; i < this.valueAry.length; i++)
        {
            this.renderAry[i].render(context, w, h);
        }
    }
    
    sort()
    {
		var r = this.generator.next();
		if(r.done)
		{
			this.done = r.done
			return;
		}
		var v = r.value;

		if(v.isSwitch)
		{
			this.renderAry[v.from].value = v.fromValue;
			this.renderAry[v.to].value = v.toValue;
		}
		else
		{
			this.renderAry[v.index].value = v.value;
		}
    }
    
	toggleAction()
	{
		if(this.inAction)
		{
			this.start();
		}
		else
		{
			this.start();
		}
	}
	
	start()
	{
		if(this.done)
		{
			this.reflesh();
		}
		this.inAction = true;
	}
	
	stop()
	{
		this.inAction = false;
	}
	
	reflesh()
	{
        this.valueAry = Sorter.CreateRandomArray(60, 400);
		this.renderAry = SorterViewObject.CraeteArray(60);
		
		this.generator = Sorter.GeneratorMergeSort(this.valueAry, 0, this.valueAry.length);
        for(var i = 0; i < this.valueAry.length; i++)
        {
            this.renderAry[i].value = this.valueAry[i];
            this.renderAry[i].index = i;
        }
		this.done = false;
	}
}

function StartCanvas()
{
    /* Canvas要素の定義など */
    var cs  = document.getElementById('cv');
    var ctx = cs.getContext('2d');
    var w = cs.width;
    var h = cs.height;
    
    var rect = new ArrayRect();
    cs.addEventListener('click', function()
    {
        rect.toggleAction();
    }
    , false);

    var objects = [];
    objects.push(rect);
    
    /* 描画フロー */
    function Render(timestamp)
    {
        // Canvas全体をクリア
        ctx.clearRect(0, 0, w, h);

        objects.forEach((obj) => obj.update());
        objects.forEach((obj) => obj.render(ctx, w, h));
        
        window.requestAnimationFrame((ts) => Render(ts));
    }
    window.requestAnimationFrame((ts) => Render(ts));
}
StartCanvas();

/*
class Rectangle
{
    constructor(x, y, width, height)
    {
        this.x = x;
        this.y = y;
        
        this.width = width;
        this.height = height;
        
        this.rw = width;
        this.rh = height;
        
        this.rx = x;
        this.ry = y;
        
        this.xSpeed = 1;
        this.ySpeed = 1;
        
        this.isBig = false;

        this.velocityX = 2; // この速度で横に移動する。
    }

    update()
    {
        if(this.width < this.rw)
        {
            this.width += 1;
        }
        else if(this.width > this.rw)
        {
            this.width -= 1;
        }
        
        if(this.height < this.rh)
        {
            this.height += 1;
        }
        else if(this.height > this.rh)
        {
            this.height -= 1;
        }
        
        var deltaX = this.rx - this.x;
        if(Math.abs(deltaX) > this.xSpeed)
        {
            if(deltaX > 0)
            {
                this.x += this.xSpeed;
            }
            else
            {
                this.x -= this.xSpeed;
            }
        }
        
        var deltaY = this.ry - this.y;
        if(Math.abs(deltaY) > this.ySpeed)
        {
            if(deltaY > 0)
            {
                this.y += this.ySpeed;
            }
            else
            {
                this.y -= this.ySpeed;
            }
        }
    }

    render(context, w, h)
    {
        context.beginPath();
        context.fillStyle = 'rgb(0, 0, 255)'; // 青色
        var half_w = Math.floor(this.width / 2);
        var half_h = Math.floor(this.height / 2);
        context.rect(this.x - half_w, this.y - half_h,
                     this.width, this.height);
        context.fill();
    }
  
    toggleSize()
    {
        if(this.isBig)
        {
            this.toSmall();
        }
        else
        {
            this.toBig();
        }
        this.isBig = !this.isBig;
    }
    
    toBig()
    {
        this.changeSize(60, 60);
    }
    
    toSmall()
    {
        this.changeSize(50, 50);
    }
    
    moveTo(x, y, speed)
    {
        this.rx = x;
        this.ry = y;
        
        var deltaX = (this.rx - this.x);
        this.xSpeed = Math.abs((deltaX / 1000) * speed);
        var deltaY = (this.ry - this.y);
        this.ySpeed = Math.abs((deltaY / 1000) * speed);
    }
    
    changeSize(w, h)
    {
        this.rw = w;
        this.rh = h;
    }
}

*/