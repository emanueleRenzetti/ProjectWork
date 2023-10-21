  //////////////ZOOM NAVBAR//////////
  let navItems = document.querySelectorAll(".nav-link");
        
  navItems.forEach(item => {
      item.addEventListener("mouseover", ingrandisciLink);
      item.addEventListener("mouseout", restringiLink);
      
      function ingrandisciLink() {
          item.style.transform = "scale(1.2)";
      }
      
      function restringiLink() {
          item.style.transform = "scale(1)";
      }
  });
  /////////////////////////////