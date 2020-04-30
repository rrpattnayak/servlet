function validate(frm)
{
	//set flag to 'yes" indicating client side form validations are done
	frm.vflag.value="yes";
	document.getElementById("nameErr").innerHTML="";
	document.getElementById("ageErr").innerHTML="";
	document.getElementById("nameErr").style="color:red";
	document.getElementById("nameErr").style="color:red";
	
	//read form data
	var name=frm.pname.value;
	var age=frm.page.value;
	//perform client side form validations
	if(name=="")//requierd rule
		{
		document.getElementById("nameErr").innerHTML="person name is mandatory";
		frm.pname.focus();
		return false;
		}//if
	if(age=="")//required rule
		{
		document.getElementById("nameErr").innerHTML="person age is mandatory";
		frm.page.focus();
		return false;
		}//if
	else
		{
		if(isNaN(age))//check whether age is numeric value or not
			document.getElementById("nameErr").innerHTML="person age musut be numeric vlaue";
		frm.page.focus();
		frm.page.value="";
		}//else
	return true;
	}//function