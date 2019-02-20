class SorterViewObject {
	constructor() {
		this.value;
		this.isMove = true;
		this.y = 0;
		this.index = 0;
		this.color = "rgb(70, 70, 70)";
	}

	render(context, w, h) {
		context.beginPath();
		context.fillStyle = this.color;
		context.rect(1 + (this.index * 11), h - this.value - (this.y * 10),
			10, this.value);
		context.fill();
	}

	static CraeteArray(length) {
		var ary = new Array(length);
		for (var i = 0; i < length; i++) {
			ary[i] = new SorterViewObject();
		}
		return ary;
	}

}

class Sorter {
	static MargeSort(ary, begin, end) {
		var length = (end - begin);
		if (length == 1) return;
		if (length == 2) {
			if (ary[begin] > ary[begin + 1]) {
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

		while (leftLength > 0 || rightLength > 0) {
			if (leftLength > 0 && rightLength > 0) {
				if (ary[leftIndex] < ary[rightIndex]) {
					tmpAry[index] = ary[leftIndex];
					index++;
					leftIndex++;
					leftLength--;
				} else {
					tmpAry[index] = ary[rightIndex];
					index++;
					rightIndex++;
					rightLength--;
				}
				continue;
			}

			if (leftLength > 0) {
				tmpAry[index] = ary[leftIndex];
				index++;
				leftIndex++;
				leftLength--;
			} else {
				tmpAry[index] = ary[rightIndex];
				index++;
				rightIndex++;
				rightLength--;
			}
		}

		Sorter.ReplaceAry(ary, tmpAry, begin, end);
	}

	static QuickSort(ary, begin, end) {
		var length = end - begin;
		if (begin > end) return;

		var center = begin + Math.floor(length / 2);
		var pivot = ary[center];

		var leftIndex = begin;
		var rightIndex = end;

		while (true) {
			while (ary[leftIndex] < pivot) leftIndex++;
			while (pivot < ary[rightIndex]) rightIndex--;
			if (leftIndex >= rightIndex) break;

			Sorter.SwitchAry(ary, leftIndex, rightIndex);

			leftIndex++;
			rightIndex--;
		}

		Sorter.QuickSort(ary, begin, --leftIndex);
		Sorter.QuickSort(ary, ++rightIndex, end);
	}

	static CreateRandomArray(aryLength, height) {
		var ary = new Array(aryLength);

		for (var i = 0; i < ary.length; i++) {
			ary[i] = Math.floor(Math.random() * height);
		}

		return ary;
	}

	static SwitchAry(ary, a, b) {
		var tmp = ary[a];
		ary[a] = ary[b];
		ary[b] = tmp;

		return ary;
	}

	static ReplaceAry(baseAry, newAry, begin, end) {
		for (var i = begin; i < end; i++) {
			baseAry[i] = newAry[i - begin];
		}
	}

	//	マージソートをgeneratorでする
	static GeneratorMergeSort(ary, begin, end) {
		function* generator(ary, begin, end) {
			//	長さを計測
			var length = (end - begin);

			//	長さが１なら終了
			if (length == 1) return;

			//	長さが２なら入れ替えて終了
			if (length == 2) {
				//	左側のほうが小さければなにもしない
				if (ary[begin] < ary[begin + 1]) return;

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
			while (!r1.done) {
				yield r1.value;
				r1 = g1.next();
			}

			//	右側をマージソート
			var g2 = Sorter.GeneratorMergeSort(ary, center, end);
			var r2 = g2.next();
			while (!r2.done) {
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
			while (leftLength > 0 || rightLength > 0) {
				//	どちらもある場合
				if (leftLength > 0 && rightLength > 0) {
					//	左のほうが値が小さい場合
					if (ary[leftIndex] < ary[rightIndex]) {
						tmpAry[index] = ary[leftIndex];
						index++;
						leftIndex++;
						leftLength--;
					}
					//	右のほうが値が小さい場合
					else {
						tmpAry[index] = ary[rightIndex];
						index++;
						rightIndex++;
						rightLength--;
					}

					continue;
				}

				//	左にしか無い場合
				if (leftLength > 0) {
					tmpAry[index] = ary[leftIndex];
					index++;
					leftIndex++;
					leftLength--;
				}
				//	右にしか無い場合
				else {
					tmpAry[index] = ary[rightIndex];
					index++;
					rightIndex++;
					rightLength--;
				}
			}

			//	一時的に保存していた値を実際に代入する
			Sorter.ReplaceAry(ary, tmpAry, begin, end);

			//	色変更
			for (var i = begin; i < end; i++) {
				var obj_pivod = {};
				obj_pivod.changeColor = true;
				obj_pivod.color = "red";
				obj_pivod.index = i;
				yield obj_pivod;
			}

			//	一つ一つ、値を変更していく
			for (var i = begin; i < end; i++) {
				var obj = {};
				obj.isSwitch = false;
				obj.index = i;
				obj.value = ary[i];

				yield obj;
			}

			//	色変更
			for (var i = begin; i < end; i++) {
				var obj_pivod = {};
				obj_pivod.changeColor = true;
				obj_pivod.color = "rgb(70, 70, 70)";
				obj_pivod.index = i;
				yield obj_pivod;
			}
		}

		return generator(ary, begin, end);
	}

	static GeneratorQuickSort(ary, begin, last) {
		function* generator(ary, begin, last) {
			var length = last - begin;
			if (begin > last) return;

			var center = begin + Math.floor(length / 2);
			var pivot = ary[center];

			var obj_pivod = {};
			obj_pivod.changeColor = true;
			obj_pivod.color = "red";
			obj_pivod.index = center;
			yield obj_pivod;

			var leftIndex = begin;
			var rightIndex = last;

			while (true) {
				while (ary[leftIndex] < pivot) leftIndex++;
				while (pivot < ary[rightIndex]) rightIndex--;
				if (leftIndex >= rightIndex) break;

				ary = Sorter.SwitchAry(ary, leftIndex, rightIndex);

				var obj = {};
				obj.isSwitch = true;
				obj.from = leftIndex;
				obj.to = rightIndex;
				yield obj;

				leftIndex++;
				rightIndex--;
			}

			var obj_pivod = {};
			obj_pivod.changeColor = true;
			obj_pivod.color = "rgb(70, 70, 70)";
			obj_pivod.index = center;
			yield obj_pivod;

			//	左側をクイックソート
			var g1 = Sorter.GeneratorQuickSort(ary, begin, --leftIndex);
			var r1 = g1.next();
			while (!r1.done) {
				yield r1.value;
				r1 = g1.next();
			}

			//	右側をクイックソート
			var g2 = Sorter.GeneratorQuickSort(ary, ++rightIndex, last);
			var r2 = g2.next();
			while (!r2.done) {
				yield r2.value;
				r2 = g2.next();
			}

		}
		return generator(ary, begin, last);
	}

}

class ArrayRect {
	constructor() {
		this.valueAry = Sorter.CreateRandomArray(60, 400);
		this.renderAry = SorterViewObject.CraeteArray(60);

		this.generator = Sorter.GeneratorMergeSort(this.valueAry, 0, this.valueAry.length);
		for (var i = 0; i < this.valueAry.length; i++) {
			this.renderAry[i].value = this.valueAry[i];
			this.renderAry[i].index = i;
		}

		this.inAction = false;
		this.done = false;
	}

	update() {
		if (!this.done && this.inAction) {
			this.sort();
		}
	}

	render(context, w, h) {
		for (var i = 0; i < this.valueAry.length; i++) {
			this.renderAry[i].render(context, w, h);
		}
	}

	sort() {
		var r = this.generator.next();
		if (r.done) {
			this.done = r.done
			return;
		}
		var v = r.value;

		if (r.value.changeColor) {
			this.renderAry[r.value.index].color = r.value.color;
			return;
		}
		if (v.isSwitch) {
			var tmp = this.renderAry[v.from].value;
			this.renderAry[v.from].value = this.renderAry[v.to].value;
			this.renderAry[v.to].value = tmp;
		} else {
			this.renderAry[v.index].value = v.value;
		}
	}

	toggleAction() {
		if (this.inAction) {
			this.start();
		} else {
			this.start();
		}
	}

	start() {
		if (this.done) {
			this.reflesh();
		}
		this.inAction = true;
	}

	stop() {
		this.inAction = false;
	}

	reflesh() {
		this.valueAry = Sorter.CreateRandomArray(60, 400);
		this.renderAry = SorterViewObject.CraeteArray(60);

		this.generator = Sorter.GeneratorQuickSort(this.valueAry, 0, this.valueAry.length - 1);
		for (var i = 0; i < this.valueAry.length; i++) {
			this.renderAry[i].value = this.valueAry[i];
			this.renderAry[i].index = i;
		}
		this.done = false;
	}
}

function StartCanvas() {
	/* Canvas要素の定義など */
	var cs = document.getElementById('cv');
	var ctx = cs.getContext('2d');
	var w = cs.width;
	var h = cs.height;

	var rect = new ArrayRect();
	cs.addEventListener('click', function () {
		rect.toggleAction();
	}, false);

	var objects = [];
	objects.push(rect);

	/* 描画フロー */
	function Render(timestamp) {
		// Canvas全体をクリア
		ctx.clearRect(0, 0, w, h);

		objects.forEach((obj) => obj.update());
		objects.forEach((obj) => obj.render(ctx, w, h));

		window.requestAnimationFrame((ts) => Render(ts));
	}
	window.requestAnimationFrame((ts) => Render(ts));
}
StartCanvas();
