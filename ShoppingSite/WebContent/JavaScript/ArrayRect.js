//	ArrayRect
//	SorterViewObjectListView
class ArrayRect {
	//	コンストラクター
	constructor(sortMode)
	{
		this.sortMode = sortMode;
		this.initialize();
		this.inAction = false;
	}

	//	Update
	update()
	{
		if (!this.done && this.inAction) 
		{
			this.sort();
			this.sort();
		}
		for (var i = 0; i < this.array.length; i++)
		{
			this.array[i].update(i);
		}
	}

	//	描画
	render(context, w, h)
	{
		for (var i = 0; i < this.array.length; i++)
		{
			this.array[i].render(context, w, h);
		}
	}

	//	ソート(1回)
	sort()
	{
		var r = this.generator.next();
		if (r.done)
		{
			this.done = r.done;
			return;
		}
		var v = r.value;

		if (v.changeColor)
		{
			this.array[v.index].color = v.color;
			return;
		}
	}

	//	ソートをトグル
	toggleAction()
	{
		if (this.inAction)
		{
			this.stop();
		}
		else
		{
			this.start();
		}
	}

	//	ソートを開始
	start()
	{
		if (this.done)
		{
			this.initialize();
		}
		this.inAction = true;
	}

	//	ソートを止める
	stop()
	{
		this.inAction = false;
	}

	//	配列を初期化
	initialize()
	{
		this.array = SorterViewObject.CraeteArray(1000);

		switch(this.sortMode)
		{
			case "merge":
				this.generator = Sorter.GeneratorMergeSort(this.array, 0, this.array.length);
				break;
			
			default:
			case "quick":
				this.generator = Sorter.GeneratorQuickSort(this.array, 0, this.array.length - 1);
				break;
		}

		this.done = false;
	}
}
