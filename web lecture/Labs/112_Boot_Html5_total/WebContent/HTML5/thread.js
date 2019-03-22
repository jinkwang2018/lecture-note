var theme=2;

function change() {
	if(theme==5) theme=2;
	postMessage(theme); 
	theme++;
    setTimeout("change()",5000);
}

change();