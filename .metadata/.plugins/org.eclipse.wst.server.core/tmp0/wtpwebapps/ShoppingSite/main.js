count1 = 0;
count2 = 0;
r = 10;
canvas = null;
ctx = null;
timerID = -1;

function start()
{
	canvas = document.getElementById('canvas_e');
	ctx = canvas.getContext('2d');
	timerID = setInterval('draw()', 100);
	
}
function draw()
{
	count1++
	if (count1 > 10)
	{
		count2++;
		if (count2 > 4)
		{
			stop();
		}
		else
		{
			r      = 10;
			count1 = 1;
			ctx.clearRect(0, 0, canvas.width, canvas.height);
		}
	}
	ctx.beginPath();
	ctx.arc(0, 0, r, Math.PI*1.5, Math.PI*2, true);
	ctx.stroke();
	r = 1.5 * r;   // r *= 1.5; でも可
}


function stop()
{
	clearInterval(timerID);
	ctx.clearRect(0, 0, canvas.width, canvas.height);
	timerID = -1;
}