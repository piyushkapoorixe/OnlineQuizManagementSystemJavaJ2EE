
//function preventBack(){window.history.forward();}
//    setTimeout("preventBack()", 0);
//    window.onunload=function(){null};




	localStorage.removeItem("counter");
	var temp=0;
    if(localStorage.getItem("counter")){
      if(localStorage.getItem("counter") <= 0 && temp==0){
        var value = 0;
      }else if(localStorage.getItem("counter") <= 0 && temp==1) {
		
		var value = 0;
		
	  }
	  else{
        var value = localStorage.getItem("counter");
      }
    }
	else{
		if(localStorage.getItem("countertemp")) 
		{
			var value = 0;
			localStorage.removeItem("countertemp");
		}
		else {
		var value = 20;
		}
    }
    document.getElementById('divCounter').innerHTML = value;

    var counter = function (){
	
      if(value <= 0){
        localStorage.setItem("counter", 0);
        value = 0;
		temp==1;
		window.location = "test1";
      }else{
        value = parseInt(value)-1;
        localStorage.setItem("counter", value);
      }
      document.getElementById('divCounter').innerHTML = "timer left is " + value;
    };

    var interval = setInterval(function (){counter();}, 1000);