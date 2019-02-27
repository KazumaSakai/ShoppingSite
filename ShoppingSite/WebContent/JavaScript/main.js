window.onload = function()
{
	var tabs = document.getElementsByClassName("tab");
	for(var i = 0; i < tabs.length; i++)
	{
		var tab = tabs[i];
		drawTab(tab);
	}
	
	var fixed =  document.getElementsByClassName("fixed")[0];
	var windowTags = document.getElementsByClassName("windowTag");
	for(var i = 0; i < windowTags.length; i++)
	{
		var windowTag = windowTags[i];
		let n = (windowTags.length - i) - 1;
		windowTag.style.top = "calc(80vh - " + (75 * n) + "px)";
	}

	var images =  document.getElementsByTagName("img");
	for(var i = 0; i < images.length; i++)
	{
		let beforeOnClick = images[i].getAttribute("onclick");
		let onclick = "popupImage('" + images[i].getAttribute("src") + "')";
		
		images[i].setAttribute("onclick", (beforeOnClick == null ? "" : beforeOnClick) + onclick);
		console.log(images[i]);
	}
}


function cartTotalPrice()
{
	return GET("./PriceAction");
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

function GET(url)
{
	var request = new XMLHttpRequest();
	request.open("GET", url, false);
	request.send(null);
	return request.responseText;
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
	
	return script;
}

function popupClose()
{
    var popup_back = document.getElementById("popup_back");
    var popup_window = document.getElementById("popup_window");
    var popup_close = document.getElementById("popup_close");

    var anim = popup_back.animate({
        opacity: [ 1, 0 ]
    },
    {
        duration: 200,
        fill: "forwards"
    });
    
    anim.onfinish = function()
    {
        popup_back.parentNode.removeChild(popup_back);
    }
}

function popupImage(imageURL)
{
    //	背景を灰色に
    var popup_back = document.createElement("div");
    document.getElementsByTagName("body")[0].appendChild(popup_back);
    popup_back.setAttribute("style", "position: fixed; top: 0px; left: 0px; width: 100%; height: 100%; background-color: rgba(0, 0, 0, 0.7); box-sizing: border-box; z-index: 10000");
    popup_back.setAttribute("id", "popup_back");

    popup_back.animate
    ({
        opacity: [ 0, 1 ]
    },
    {
        duration: 200,
        fill: "forwards"
    });
    
    //	ラッパー
    var wrapper = document.createElement("div");
    wrapper.setAttribute("style", "position: relative; top: 50%; left: 50%;" +
						    		" width: 80vw; height: 80vh;" +
						    		" transform: translate(-40vw, -40vh);" +
						    		" text-align: center");
    popup_back.appendChild(wrapper);

    //	ラッパー
    var wrapper2 = document.createElement("div");
    wrapper2.setAttribute("style", "position: absolute; height: 100%; display: inline-block; transform: translateX(-50%);");
    wrapper.appendChild(wrapper2);
    
    //	画像	
    var image = document.createElement("img");
    image.setAttribute("src", imageURL);
    image.setAttribute("style", "position: relative;" +
						    		" width: auto; height: auto;" +
						    		" max-width: 100%; max-height: 100%");
    wrapper2.appendChild(image);
    
    //	ボタン1	
    var button = document.createElement("div");
    button.setAttribute("class", "button");
    button.setAttribute("style", "top: -6px; right: -6px");
    button.setAttribute("onclick", "popupClose()");
    wrapper2.appendChild(button);

    var cross = document.createElement("div");
    cross.setAttribute("class", "cross");
    button.appendChild(cross);
}
