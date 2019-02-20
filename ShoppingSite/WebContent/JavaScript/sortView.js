//	描画を開始する
function StartCanvas()
{
	//	Canvas
	var cv = document.getElementById('cv');
	var ctx = cv.getContext('2d');
	var w = cv.width;
	var h = cv.height;
	
	//	オブジェクト作成
	var rect = new ArrayRect("quick");
	
	//	ソートアルゴリズム選択ボックス
	var algorithm = ["quick", "merge"];
	cv.parentElement.insertBefore(DOMLibrary.CreateSelect(algorithm, function (i)
	{ 
		rect.sortMode = algorithm[i];
	}), cv);
	
	cv.addEventListener("click", function ()
	{
		rect.toggleAction();
	}, false);

	var objects = [];
	objects.push(rect);
	
	//	描画フロー
	function Render(timestamp)
	{
		// Canvas全体をクリア
		ctx.clearRect(0, 0, w, h);

		objects.forEach((obj) => obj.update());
		objects.forEach((obj) => obj.render(ctx, w, h));

		//	ループ
		window.requestAnimationFrame((ts) => Render(ts));
	}
	
	//	ループ開始
	window.requestAnimationFrame((ts) => Render(ts));
}

//	DOM操作で外部JavaScriptを読み込む
function LoadScript(url, callback)
{
	//	<script>作成
	var script = document.createElement("script");
	script.type = "text/javascript";
	script.src = url;
	
	script.onload = callback;

	//	<head>に追加
	document.getElementsByTagName("head")[0].appendChild(script);
	
	var callback = {};
	callback.script = script;
	
	return script;
}

window.onload =
		(callback) => LoadScript("./JavaScript/SorterViewObject.js",
		(callback) => LoadScript("./JavaScript/Sorter.js",
		(callback) => LoadScript("./JavaScript/ArrayRect.js",
		(callback) => LoadScript("./JavaScript/DOMLibrary.js",
		(callback) => StartCanvas()))));
