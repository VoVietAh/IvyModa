//------------------- Menu_Item -------------------
const header = document.querySelector("header");
window.addEventListener("scroll", function() {
  let y = window.pageYOffset;
  if(y > 0) {
    header.classList.add("sticky");
  } else {
    header.classList.remove("sticky");
  }
});
//------------------- Menu_SliderBar_Cartegory -------------------
const itemsliderbar = document.querySelectorAll(".cartegory_left_li");
itemsliderbar.forEach(function(menu,index){
    menu.addEventListener("click",function(){
        menu.classList.toggle("block");
    })
})
//-------------------PRODUCT-------------------
const bigimg = document.querySelector(".product-content-left-big-img img")
const smallimg = document.querySelectorAll(".product-content-left-small-img img")
smallimg.forEach(function(imgitem,x){
  imgitem.addEventListener("click",function(){
    bigimg.src = imgitem.src
  })
})

const baoquan = document.querySelector(".baoquan")
const chitiet = document.querySelector(".chitiet")
if(baoquan){
  baoquan.addEventListener("click",function(){
    document.querySelector(".product-content-right-bottom-content-chitiet").style.display = "none"
    document.querySelector(".product-content-right-bottom-content-baoquan").style.display = "block"
  })
}
if(chitiet){
  chitiet.addEventListener("click",function(){
    document.querySelector(".product-content-right-bottom-content-chitiet").style.display = "block"
    document.querySelector(".product-content-right-bottom-content-baoquan").style.display = "none"
  })
}

const button = document.querySelector(".product-content-right-bottom-top")
if(button){
  button.addEventListener("click",function(){
    document.querySelector(".product-content-right-bottom-content-big").classList.toggle("activeB")
  })
}