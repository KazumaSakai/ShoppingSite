window.onload = function()
{
	var tabs = document.getElementsByClassName("tab");
	for(var i = 0; i < tabs.length; i++)
	{
		var tab = tabs[i];
		drawTab(tab);
		
	}
}

function drawTab(tab)
{
	var header = document.createElement("div");
	header.className = "header";
	tab.parentElement.insertBefore(header, tab);
	
	var tabIndex = tab.getAttribute("index");
	var tabChilds = tab.children;
	for(let j = 0; j < tabChilds.length; j++)
	{
		var tabChild = tabChilds[j];
		if(j == tabIndex)
		{
			tabChild.removeAttribute("hidden");
		}
		else
		{
			tabChild.setAttribute("hidden", "");
		}
		
		var headerTab = document.createElement("div");
		if(j == tabIndex) headerTab.classList.add("activeHeaderTab");
		headerTab.classList.add("headerTab");
		headerTab.style = "width: calc(calc(100% - 1px) / " + tabChilds.length + " + 1px)";
		headerTab.innerHTML = tabChild.getAttribute("name");
		headerTab.addEventListener("click", function()
	  	{
			header.parentElement.removeChild(header);
			tab.setAttribute("index", j);
			drawTab(tab);
		});
		header.appendChild(headerTab);
	}
}