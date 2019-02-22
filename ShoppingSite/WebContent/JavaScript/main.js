window.onload = function()
{
	var tabs = document.getElementsByClassName("tab");
	for(var i = 0; i < tabs.length; i++)
	{
		var tab = tabs[i];
		drawTab(tab);

	}
	LoadScript("./JavaScript/DOMLibrary.js");
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

function dropMenu(element)
{
	var dropMenu = element.getElementsByClassName("dropMenu")[0];
	dropMenu.removeAttribute("hidden");
}

//DOM操作で外部JavaScriptを読み込む
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
