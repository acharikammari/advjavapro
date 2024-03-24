//alert("welcome to Javascript")
//console.log("welcome to Javascript")
//document.write("welcome to Javascript")

//let username="sathya";
//let password="sathya@123";
//if(username==="sathya"&& password==="sathya@123")
//{
	//alert("Login sucess......");
//}
//else
//{
	//alert("Login fail......");
//}
//let i=parseInt(prompt("enter the i value"));
//while(i<=100)
//{
	//if(i%3===0 &&i%5===0)
	//{
		//document.write("FizzBuss"+" ");
		
	//}
	//else if(i%3===0)
	//{
		//document.write("fizz"+" ");
	//}
	//else if(i%5===0)
	//{
		//document.write("buzz"+" ");
	//}
	//else
	//{
		//document.write(+" "+i);
	//}
	//i++;
//}




let ratanmass=parseInt(prompt("enter the ratanmass"));
let anumass=parseInt(prompt("enter the anumass"));
let ratanheight=parseFloat(prompt("enter the ratanheight"));
let anuheight=parseFloat(prompt("enter the anuheight "));

let BMIratan=53/(5.7*5.7);
let BMIanu=45/(5.6*5.6);

console.log("BMI of ratan:"+BMIratan);
console.log("BMI of anu:"+BMIanu);

alert("BMI of ratan:"+BMIratan);
alert("BMI of anu:"+BMIanu);

let isRatanHigherBMI=true;
if(BMIratan>BMIanu)
{
	console.log(isRatanHigherBMI+"type of"+typeof(isRatanHigherBMI));
	document.write(isRatanHigherBMI);
}




