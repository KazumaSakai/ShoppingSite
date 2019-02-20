//	Sorter
class Sorter {
	//	マージソート
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

	//	クイックソート
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

	//	ランダムな配列を作成
	static CreateRandomArray(aryLength, height) {
		var ary = new Array(aryLength);

		for (var i = 0; i < ary.length; i++) {
			ary[i] = Math.floor(Math.random() * height);
		}

		return ary;
	}

	//	配列の中身をスイッチ
	static SwitchAry(ary, a, b) {
		var tmp = ary[a];
		ary[a] = ary[b];
		ary[b] = tmp;

		return ary;
	}

	//	配列を置き換え
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
				if (ary[begin].value < ary[begin + 1].value) return;

				Sorter.SwitchAry(ary, begin, begin + 1);

				var obj = {};
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

			//	色変更
			for (var i = begin; i < end; i++) {
				ary[i].color = "red";
			}
			
			//	どちらも無くなるまで回す
			while (leftLength > 0 || rightLength > 0) {
				//	どちらもある場合
				if (leftLength > 0 && rightLength > 0) {
					//	左のほうが値が小さい場合
					if (ary[leftIndex].value < ary[rightIndex].value) {
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


			//	一つ一つ、値を変更していく
			for (var i = begin; i < end; i++) {
				ary[i] = tmpAry[i - begin];
				var obj = {};
				yield obj;
			}

			//	色変更
			for (var i = begin; i < end; i++) {
				ary[i].color = "rgb(70, 70, 70)";
			}
		}

		return generator(ary, begin, end);
	}

	//	クイックソートをgeneretorでする
	static GeneratorQuickSort(ary, begin, last) {
		function* generator(ary, begin, last) {
			var length = last - begin;
			if (begin > last) return;

			var center = begin + Math.floor(length / 2);
			var pivot = ary[center];

			pivot.color = "red";

			var leftIndex = begin;
			var rightIndex = last;

			while (true) {
				while (ary[leftIndex].value < pivot.value) leftIndex++;
				while (pivot.value < ary[rightIndex].value) rightIndex--;
				if (leftIndex >= rightIndex) break;

				Sorter.SwitchAry(ary, leftIndex, rightIndex);

				ary[leftIndex].color = "blue";
				ary[rightIndex].color = "blue";
				
				var obj = {};
				yield obj;
				
				ary[leftIndex].color = "rgb(70, 70, 70)";
				ary[rightIndex].color = "rgb(70, 70, 70)";

				leftIndex++;
				rightIndex--;
			}

			pivot.color = "rgb(70, 70, 70)";

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
