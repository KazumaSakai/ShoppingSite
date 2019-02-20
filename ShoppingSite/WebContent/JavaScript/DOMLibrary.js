class DOMLibrary
{
	//	<select>を配列から生成
	static CreateSelect(ary, onchange)
	{
		//	select作成
		var select = document.createElement("select");
		select.setAttribute("style", "margin: 5px; padding: 2px; width: 100px");
		select.addEventListener("change", function()
		{
			onchange(this.selectedIndex);
		});
		
		//	option作成
		ary.forEach((text) =>
		{
			var option = document.createElement("option");
			option.insertAdjacentHTML("afterbegin", text);
			select.appendChild(option);
		});
		
		return select;
	}
}