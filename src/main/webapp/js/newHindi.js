/**
 * 
 */
function display_text()
{
	document.write(form1.textArea.value);
	// = "" ;
	//return 0;
}

var lcharno = '' ;  // last character pressed on keyboard  (not in unicoe number) 	

function changeVal() 
{
	//ta= form1.textArea;
	var llchar = form1.textArea.value.charCodeAt(form1.textArea.value.length - 3);   // last to last character// 
	var lchar = form1.textArea.value.charCodeAt(form1.textArea.value.length - 2);   // last character
	var cchar = form1.textArea.value.charAt(form1.textArea.value.length - 1);	// current char pressed on ketboard
	
	
//	alert (lchar);
	//document.write (lastchar);
	
	if (cchar == '~')  /// this will cause 
	{
			form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2381) ;
		lcharno = cchar;  // /save currents as last;
		return; 	
	}
	
	
	if (cchar == '*')  /// this will cause 
	{
			form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(39) ;
		lcharno = cchar;  // /save currents as last;
		return; 	
	}

	if (cchar == '$')  /// this will cause .
	{
			form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2365) ;
		lcharno = cchar;  // /save currents as last;
		return; 	
	}

	if (cchar == '^')  /// this will cause .
	{
			form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(39) ;
		lcharno = cchar;  // /save currents as last;
		return; 	
	}

	if (cchar == ':')  /// this will cause 
	{
			form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2352,2370) ;
		lcharno = cchar;  // /save currents as last;
		return; 	
	} 

	if (cchar == '`')  /// this will cause .
	{
			form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2371) ;
		lcharno = cchar;  // /save currents as last;
		return; 	
	}
	

	if (cchar == '&')  /// this will convert .
	{
			form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(45) ;
		lcharno = cchar;  // /save currents as last;
		return; 	
	}
	if (cchar == '%')  /// this will convert to 
	{
			form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2307) ;
		lcharno = cchar;  // /save currents as last;
		return; 	
	}
	if (cchar == '-')  /// this will convert to 
	{
			form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(46) ;
		lcharno = cchar;  // /save currents as last;
		return; 	
	}
	if (cchar == '_')  /// this will convert to 
	{
			form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2315) ;
		lcharno = cchar;  // /save currents as last;
		return; 	
	}
	
	if (cchar == 'A') /// this will cause 
	{	
				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2404) ;
		lcharno = cchar;  // /save currents as last;
		return;
	}

	if (cchar == 'a') /// this will cause 
	{	
		
				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2306) ;
		lcharno == ''
		return;
	}

	if (cchar == 'I') /// this will cause 
	{	
				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2346,2381) ;
		lcharno = cchar;  // /save currents as last;
		return;
	}
	if (cchar == 'i') /// this will cause 
	{		form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2346) ;
		lcharno = cchar;  // /save currents as last;
		return;
	}
	if (cchar == 'O') /// this will cause 
	{	 
				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2357,2381) ;
		lcharno = cchar;  // /save currents as last;
		return;
	}
	if (cchar == 'o') /// this will cause 
	{		form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2357) ;
		lcharno = cchar;  // /save currents as last;
		return;
	}
	if (cchar == 'E') /// this will cause 
	{			form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2350,2381) ;
		lcharno = cchar;  // /save currents as last;
		return;
	}
	if (cchar == 'e') /// this will cause 
	{	
		
		form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2350) ;
		lcharno = cchar;  // /save currents as last;
		return;

	}
	
	if (cchar == 'U') /// this will cause 
	{			form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2344,2381) ;
		lcharno = cchar;  // /save currents as last;
		return;		
	}
	if (cchar == 'u') /// this will cause 
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2344) ;
		lcharno = cchar;  // /save currents as last;
		return;
	}

// (I-N-D-I-A) Intellenge N Determination In form1  
	if (cchar == ' ') //
	{	if ( lcharno == 'a' && lchar != 2366 )  // if space pressed and last characrer was 'a' the convert it to vowel 'aa'
				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1)  + String.fromCharCode(2366)  + " "; 
				lcharno == ''
		return;		
	}
	
	if (cchar == 'K') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2332,2381,2334) ;
		lcharno == ''
		return;	
	}
if (cchar == 'k') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2366) ;
		lcharno == ''
		return;	
	}
	
if (cchar == 'Y') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2354,2381) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'y') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2354) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'P') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2330,2381) ;
		lcharno == ''
		return;	
	}


	if (cchar == 'p') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2330) ;
		lcharno == ''
		return;	
	}

	if (cchar == '{') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2325,2381,2359,2381) ;
		lcharno == ''
		return;	
	}

	if (cchar == '}') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2342,2381,2357) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'S') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2376) ;
		lcharno == ''
		return;	
	}

	if (cchar == 's') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2375) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'D') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2325,2381) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'd') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2325) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'F') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2341,2381) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'f') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2367) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'G') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2312) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'g') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2361) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'H') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2349,2381) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'h') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2368) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'J') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2358,2381,2352) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'j') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2352) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'L') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2360,2381) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'l') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2360) ;
		lcharno == ''
		return;	
	}

	if (cchar == '"') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2359,2381) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'Z') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2352,2381) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'z') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2381,2352) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'X') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2327,2381) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'x') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2327) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'C') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2348,2381) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'c') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2348) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'V') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2335) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'v') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2309) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'B') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2336) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'b') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2311) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'N') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2331) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'n') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2342) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'M') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2337) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'm') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2313) ;
		lcharno == ''
		return;	
	}

	if (cchar == '<') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2338) ;
		lcharno == ''
		return;	
	}

	if (cchar == '>') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2333) ;
		lcharno == ''
		return;	
	}

	if (cchar == '?') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2328,2381) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'R') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2340,2381) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'r') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2340) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'T') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2332,2381) ;
		lcharno == ''
		return;	
	}

	if (cchar == 't') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2332) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'W') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2373) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'w') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2370) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'Q') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2347) ;
		lcharno == ''
		return;	
	}

	if (cchar == 'q') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2369) ;
		lcharno == ''
		return;	
	}

	if (cchar == '=') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2340,2381,2352) ;
		lcharno == ''
		return;	
	}
if (cchar == '+') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2364) ;
		lcharno == ''
		return;	
	}
	if (cchar == '[') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2326,2381) ;
		lcharno == ''
		return;	
	}

	if (cchar == ']') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(44) ;
		lcharno == ''
		return;	
	}

	if (cchar == ';') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2351) ;
		lcharno == ''
		return;	
	}

	if (cchar == '"') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2358) ;
		lcharno == ''
		return;	
	}

	if (cchar == ',') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2319) ;
		lcharno == ''
		return;	
	}

	if (cchar == '.') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2339,2381) ;
		lcharno == ''
		return;	
	}

	if (cchar == '/') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2343,2381) ;
		lcharno == ''
		return;	
	}

	if (cchar == '!') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2323) ;
		lcharno == ''
		return;	
	}

if (cchar == '(') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2384) ;
		lcharno == ''
		return;	
	}

if (cchar == ')') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2342,2381,2343) ;
		lcharno == ''
		return;	
	}

if (cchar == '|') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2328) ;
		lcharno == ''
		return;	
	}

if (cchar == '#') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2352,2370) ;
		lcharno == ''
		return;	
	}

if (cchar == '@') /// this will cause
	{				form1.textArea.value = form1.textArea.value.substring(0,form1.textArea.value.length - 1) + String.fromCharCode(2324) ;
		lcharno == ''
		return;	
	}



	
	lcharno = cchar;  // /save currents as last;
	

	//alert("&#2351;&#2375;");
	//alert(String.fromCharCode(2351,2375));
}