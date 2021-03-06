<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>corin2 Login</title>
    <style>
    body {
    background: #566270;
}

form {
    width: 320px;
    padding: 60px 25px 80px;
    margin: 50px auto;
    background: #566270;
    display: flex;
    flex-direction: column;
}

svg {
    width: 70%;
    border-radius: 50%;
    background: #fff;
    margin-bottom: 40px;
    align-self: center;
    transform-style: preserve-3d;
}

input {
    font-size: 16px;
    border: 0;
    border-radius: 5px;
    outline: 0;
    padding: 10px 15px;
    margin-top: 15px;
}

@keyframes lookaway-up {
    from {
        transform: rotate3d(.2, 0, -.01, 20deg);
    }

    to {
        transform: rotate3d(.2, -.05, -.01, 20deg);
    }
}

@keyframes lookaway-down {
    0% {
        transform: rotate3d(-.2, 0, -.01, 20deg);
    }

    100% {
        transform: rotate3d(-.2, -.05, .01, 20deg);
    }
}

.ears {
    transform-origin: 50% 50% 5px;
}

.eyes {
    transform-origin: 50% 50% -40px;
}

.muzzle {
    transform-origin: 50% 50% -44px;
}

.ears, .eyes, .muzzle {
    transition: transform .5s;
}

.focused {
    transition: transform .1s;
}

.look-away .ears,
.look-away .eyes,
.look-away .muzzle {
    transition-duration: .3s;
    animation: 3s infinite alternate;
}

.look-away.up .ears,
.look-away.up .eyes,
.look-away.up .muzzle {
    transform: rotate3d(.2, 0, 0, 20deg) !important;
}

.look-away.down .ears,
.look-away.down .eyes,
.look-away.down .muzzle {
    transform: rotate3d(-.2, 0, 0, 20deg) !important;    
}

.look-away.playing.up .ears,
.look-away.playing.up .eyes,
.look-away.playing.up .muzzle {
    animation-name: lookaway-up;
}

.look-away.playing.down .ears,
.look-away.playing.down .eyes,
.look-away.playing.down .muzzle {
    animation-name: lookaway-down;
}

    </style>
</head>
<body>
    <form>
        <svg id="ryan" viewBox="0 0 120 120" xmlns="http://www.w3.org/2000/svg">
            <path d="M0,150 C0,65 120,65 120,150" fill="#E0E3DA" stroke="#000" stroke-width="2.5" />
             <circle cx="60" cy="132" r="30" fill="#ffffff" />           
            <g class="ears">
                <!--��-->
                <path d="M60,40 30,10 20,40" fill="#E0E3DA" stroke="#000" stroke-width="2.5" stroke-linecap="round" transform="rotate(-10,38,24)" />
                <path d="M30,40 30,10 20,40" fill="#ffffff" stroke="#000" stroke-width="2.5" stroke-linecap="round" transform="rotate(-10,38,24)" />
                <path d="M60,40 90,10 100,40" fill="#E0E3DA" stroke="#000" stroke-width="2.5" stroke-linecap="round" transform="rotate(10,82,24)" />
                <path d="M90,40 90,10 100,40" fill="#ffffff" stroke="#000" stroke-width="2.5" stroke-linecap="round" transform="rotate(10,82,24)" />
              
            </g>
            <circle cx="60" cy="60" r="40" fill="#E0E3DA" stroke="#000" stroke-width="2.5" />
            
            <g class="eyes">
                <!-- left eye and eyebrow-->
                 
                <circle cx="44" cy="55" r="3" fill="#000" />
                <!-- right eye and eyebrow -->
                
                <circle cx="76" cy="55" r="3" fill="#000" />
            </g>
            <g class="muzzle">
              <polygon points="59,66.5,60,66.4,61,66.5,60,68" fill="#000"  stroke="#000" stroke-width="5" stroke-linejoin="round" />
              <!--�Ӹ�ī��-->
                
                <line x1="46" x2="49" y1="46" y2="35" stroke="#000" stroke-width="2" stroke-linecap="round" />
                <line x1="46" x2="56" y1="46" y2="38" stroke="#000" stroke-width="2" stroke-linecap="round" />
                <line x1="59" x2="56" y1="46" y2="38" stroke="#000" stroke-width="2" stroke-linecap="round" />
                <line x1="59" x2="64" y1="46" y2="37" stroke="#000" stroke-width="2" stroke-linecap="round" />
                <line x1="69" x2="64" y1="44" y2="37" stroke="#000" stroke-width="2" stroke-linecap="round" />
                <line x1="69" x2="72" y1="44" y2="35" stroke="#000" stroke-width="2" stroke-linecap="round" />
               
                
              <!--���� ����-->
              <line x1="30" x2="51" y1="61" y2="65" stroke="#000" stroke-width="1" stroke-linecap="round" />
              <line x1="30" x2="51" y1="68" y2="68" stroke="#000" stroke-width="1" stroke-linecap="round" />
              <line x1="30" x2="51" y1="75" y2="71" stroke="#000" stroke-width="1" stroke-linecap="round" />
              <!--������ ����-->
              <line x1="70" x2="91" y1="65" y2="61" stroke="#000" stroke-width="1" stroke-linecap="round" />
              <line x1="70" x2="91" y1="68" y2="68" stroke="#000" stroke-width="1" stroke-linecap="round" />
              <line x1="70" x2="91" y1="71" y2="75" stroke="#000" stroke-width="1" stroke-linecap="round" />
              <!--��-->
              <polygon points="58,81,64,81,56,81,60,81" fill="#000" stroke="#000" stroke-width="3" stroke-linejoin="round" />
            </g>
        </svg>
        <input type="text" placeholder="email@domain.com">
        <input type="password" placeholder="Password">
    </form>
    <script>
    (function(){

		const ryan = document.querySelector('#ryan');
		const face = document.querySelectorAll('.ears, .eyes, .muzzle');
		const email = document.querySelector('input[type="text"]');
		const password = document.querySelector('input[type="password"]');
		const fauxInput = document.createElement('div');
		const span = document.createElement('span');
		let timer = null;
		
		function rotate3d(x, y, z, rad) {
		    const value = `rotate3d(${x}, ${y}, ${z}, ${rad}rad)`;
		    for (let i=0; i < face.length; i++) {
		        face[i].style.transform = value;
		    }
		}
		
		function focus(event) {
		    event.target.classList.add('focused');
		    copyStyles(event.target);
		    event.target.type === 'password' ? lookAway(event) : look(event);
		}
		
		function reset(event) {
		    event.target.classList.remove('focused');
		    ryan.classList.remove('playing');
		
		    clearTimeout(timer);
		    timer = setTimeout( () => {
		        ryan.classList.remove('look-away', 'down', 'up');
		        rotate3d(0,0,0,0);
		    }, 1 );
		}
		
		function copyStyles(el) {
		    const props = window.getComputedStyle(el, null);
		
		    if ( fauxInput.parentNode === document.body ) {
		        document.body.removeChild(fauxInput);
		    }
		
		    fauxInput.style.visibility = 'hidden';
		    fauxInput.style.position = 'absolute';
		    fauxInput.style.top = Math.min(el.offsetHeight * -2, -999) + 'px';
		
		    for(let i=0; i < props.length; i++) {
		        if (['visibility','display','opacity','position','top','left','right','bottom'].indexOf(props[i]) !== -1) {
		            continue;
		        }
		        fauxInput.style[props[i]] = props.getPropertyValue(props[i]);
		    }
		
		    document.body.appendChild(fauxInput);
		}
		
		function look(event) {
		    const el = event.target;
		    const text = el.value.substr(0, el.selectionStart);
		
		    span.innerText = text || '.';
		
		    const ryanRect = ryan.getBoundingClientRect();
		    const inputRect = el.getBoundingClientRect();
		    const caretRect = span.getBoundingClientRect();
		    const caretPos = caretRect.left + Math.min(caretRect.width, inputRect.width) * !!text;
		    const distCaret = ryanRect.left + ryanRect.width/2 - inputRect.left - caretPos;
		    const distInput = ryanRect.top + ryanRect.height/2 - inputRect.top;
		    const y = Math.atan2(-distCaret, Math.abs(distInput)*3);
		    const x =  Math.atan2(distInput, Math.abs(distInput)*3 / Math.cos(y));
		    const angle = Math.max(Math.abs(x), Math.abs(y));
		
		    rotate3d(x/angle, y/angle, y/angle/2, angle);
		}
		
		function lookAway(event) {
		    const el = event.target;
		    const ryanRect = ryan.getBoundingClientRect();
		    const inputRect = el.getBoundingClientRect();
		    const distInput = ryanRect.top + ryanRect.height/2 - inputRect.top;
		
		    ryan.classList.add( 'look-away', distInput < 0 ? 'up' : 'down' );
		
		    clearTimeout(timer);
		    timer = setTimeout( () => {
		        ryan.classList.add( 'playing' );
		    }, 300);
		}
		
		fauxInput.appendChild(span);
		
		email.addEventListener( 'focus', focus, false );
		email.addEventListener( 'keyup', look, false );
		email.addEventListener( 'click', look, false );
		email.addEventListener( 'blur', reset, false );
		
		password.addEventListener( 'focus', lookAway, false );
		password.addEventListener( 'blur', reset, false );
		
		})();
    </script>
</body>
</html>