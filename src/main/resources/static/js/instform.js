"use strict";
(function () {
 // const btn = document.getElementById('addInst');
 // btn.addEventListener('click', function () {
 //  document.getElementById('instForm').classList.remove('instHide');
 // })

 // const btn = document.getElementById('addInst');
 // btn.addEventListener('click', function () {
 // const linksArray = Array.from(document.querySelectorAll('.instHide')); // we use Array.from to transform the NodeList from querySelectorAll to an array. Needs to IE11
 // linksArray.forEach(linkEl => { // we search for every span and em inside the link
 //  linksArray.removeClass(".instHide");
 // });
 // });

 const btn = document.getElementById('addInst');
 btn.addEventListener('click', function () {
  let hidden = document.getElementsByClassName("instHide");
  console.log(hidden);
  while (hidden.length)
   hidden[0].classList.remove("instHide");
 })
 const btn2 = document.getElementById("bio-edit")
 btn2.addEventListener('click',function (){
  const edit = document.getElementsByClassName("editable")
  for(let i = 0; i<edit.length; i++) {
   edit[i].removeAttribute("disabled")
   edit[i].classList.remove("profile-input")

  }
 })

}())