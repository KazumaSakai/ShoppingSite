//	Load CSV

async function asyncStart()
{
	var dataSet = ToJson(await d3.text("./ItemSalesAction.action?item_id=" + item_id));
	
	//var dataSet = ToJson(await d3.text("./d3.json"));
	var maxPrice = d3.max(dataSet, function (d) { return d.price; });
	var maxQuantity = d3.max(dataSet, function (d) { return d.quantity; });
	var length = dataSet.length;
	
	console.log(dataSet);
	
	//	define
    var height = 500;
    var width = 700;
    var margin = { "top": 50, "bottom": 60, "right": 60, "left": 60 };
	var graphWidth = width - margin.left - margin.right;
	var graphHeight = height - margin.top - margin.bottom;
	

    var cv = d3.select("#myGraph").style("width", width).style("height", height);
	
	/*
	 *		横軸メモリ
	 */
	//	横軸メモリサイズ
	var xScale = d3.scaleLinear()
		.domain([0, length - 1])
		.range([0, graphWidth]);
	
	//	横軸メモリの文字
    var axisX = d3.axisBottom(xScale).tickValues([0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]).tickFormat(function (d, i) { return dataSet[Math.floor(d)].year + "年/" + dataSet[Math.floor(d)].month + "月"; });
	
	//	横軸メモリ描画
    var xm = cv.append("g")
        .attr("transform", "translate(" + margin.left + "," + (height - margin.bottom) + ")")
        .call(axisX);
	
	xm.selectAll("text")
		.attr("transform", "rotate(20)")
		.attr("x", "10")
		.attr("y", "20");
	
	xm.append("text")
        .attr("fill", "black")
        .attr("x", graphWidth / 2)
        .attr("y", 55)
        .attr("text-anchor", "middle")
        .attr("font-size", "10pt")
        .attr("font-weight", "bold")
        .text("日付");
	
	/*
	 *		縦軸目盛 左　売上
	 */
	//	縦軸メモリサイズ
	var yScale = d3.scaleLinear()
		.domain([maxPrice, 0])
		.range([0, graphHeight]);
	
	//	縦軸メモリの文字
	var axisY = d3.axisLeft(yScale).tickFormat(function (d,i) { return d / 10000 + "万円" });
	
	//	縦軸メモリ描画
    cv.append("g")
        .attr("transform", "translate(" + margin.left + "," + margin.top + ")")
        .call(axisY)
        .append("text")
        .attr("fill", "black")
        .attr("text-anchor", "middle")
        .attr("x", -20)
        .attr("y", margin.top - 65)
        .attr("font-weight", "bold")
        .attr("font-size", "10pt")
        .text("売上");
	
	
	/*
	 *		縦軸目盛 右 売上個数
	 */
	//	縦軸メモリサイズ
	var yScale2 = d3.scaleLinear()
		.domain([maxQuantity, 0])
		.range([0, graphHeight]);
	
	//	縦軸メモリの文字
	var axisY2 = d3.axisRight(yScale2).tickFormat(function (d,i) { return d + "個" });
	
	//	縦軸メモリ描画
    cv.append("g")
        .attr("transform", "translate(" + (width - margin.right) + "," + margin.top + ")")
        .call(axisY2)
        .append("text")
        .attr("fill", "black")
        .attr("text-anchor", "middle")
        .attr("x", 20)
        .attr("y", margin.top - 65)
        .attr("font-weight", "bold")
        .attr("font-size", "10pt")
        .text("販売個数");
	
	
	/*
	 *		グラフを描画
	 */
    cv.append("path")
        .datum(dataSet)
        .attr("fill", "none")
        .attr("stroke", "steelblue")
        .attr("stroke-width", 2)
        .attr("d", d3.line()  
            .x(function (d, i)
            {
                var origin = margin.left;

				
                return origin + (graphWidth / (length - 1)) * i + 1;
            })
            .y(function (d, i)
            {
                var origin = (height - margin.bottom);

                return origin - (graphHeight / maxPrice) * d.price;
            }));
}

asyncStart();


function ToJson(str)
{
	str = str.split("&#034;").join("\"");
	return JSON.parse(str);
}
