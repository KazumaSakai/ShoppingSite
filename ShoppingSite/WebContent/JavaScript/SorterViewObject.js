//	SorterViewObject
class SorterViewObject {

	//	コンストラクタ
	constructor(value) {
		this.value = value;

		//	左側のマージン
		this.space = 0;

		//	位置
		this.x = 0;
		this.y = 0;

		this.height = 0;
		this.width = (1 / 1000);

		this.isMove = false;
		this.color = "rgb(70, 70, 70)";
	}

	//	毎フレーム
	update(index) {
		this.x = (index / 1000);
		this.y = 1 - (this.value / 1000);
		this.height = (this.value / 1000);
	}

	//	描画
	render(context, w, h) {
		context.beginPath();
		context.fillStyle = this.color;

		context.rect(this.x * w, this.y * h, this.width * w, this.height * h);
		context.fill();
	}

	//	配列作成
	static CraeteArray(length) {
		var ary = new Array(length);
		for (var i = 0; i < length; i++) {
			ary[i] = new SorterViewObject(Math.floor(Math.random() * 1000));
		}
		return ary;
	}

}
