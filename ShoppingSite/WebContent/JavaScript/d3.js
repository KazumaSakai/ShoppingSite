//	Load CSV

async function asyncStart()
{
	var dataSet = ToJson(await d3.text("./ItemSalesAction.action?item_id=1"));

	d3.select("#myGraph")
		.selectAll("rect")
		.data(dataSet)
		.enter()
		.append("rect")
		.attr("x", 10)
		.attr("y", function(d, i)
			{
				return (i * 10) + 2;
			})
		.on("click", function(){
			d3.select(this)
				.style("fill", "cyan")
			})
		.attr("height", "8px")
		.attr("width", "0px")
		.transition()
		.delay(function(d, i)
			{
				return i * 500;
			})
		.duration(2500)
		.attr("width", function(d, i)
				{
					return d.quantity + "px";
				});

	var xScale = d3.scaleLinear()
		.domain([0, 300])
		.range([0, 300]);
	
	d3.select("#myGraph")
		.append("g")
		.attr("class", "axis")
		.attr("transform", "translate(10, " + ((dataSet.length) * 10 + 2) + ")")
		.call(d3.axisBottom(xScale));
}

asyncStart();


function ToJson(str)
{
	str = str.split("&#034;").join("\"");
	return JSON.parse(str);
}
