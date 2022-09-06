"use strict";
(function () {

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
   edit[i].classList.remove("profile-input","bioHide")
  }

 })
 const btn3 = document.getElementById("des-edit")
 btn3.addEventListener('click',function (){
  const edit = document.getElementsByClassName("edits")
  for(let i = 0; i<edit.length; i++) {
   edit[i].removeAttribute("disabled")
   edit[i].classList.remove("profile-input", "desHide")
   $('.medlnk').on("click", function(e) {
    e.preventDefault();
   })
  }
 })

}())
