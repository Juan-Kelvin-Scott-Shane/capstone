
"use strict"
document.getElementById("button").addEventListener("click",function(event){
  event.preventDefault()
})
  let day =new Date(document.getElementById("date").value.split("/"))
  let year = day[0]
  let month= day[1]
  let date1= day[2]
console.log(year)
console.log(day)



