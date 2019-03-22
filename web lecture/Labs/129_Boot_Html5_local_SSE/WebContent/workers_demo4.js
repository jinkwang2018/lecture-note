var i=0;

function timedCount()
{
i+=parseInt(Math.random()*14);
postMessage(i);
setTimeout("timedCount()",700);
}
timedCount();