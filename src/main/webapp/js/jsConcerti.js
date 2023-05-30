const gap4 = 16;

const carousel4 = document.getElementById("carousel4"),
  content4 = document.getElementById("content4"),
  next4 = document.getElementById("next4"),
  prev4 = document.getElementById("prev4");

next4.addEventListener("click", e => {
  carousel4.scrollBy(width + gap4, 0);
  if (carousel4.scrollWidth !== 0) {
    prev4.style.display = "flex";
  }
  if (content4.scrollWidth - width - gap4 <= carousel4.scrollLeft + width) {
    next4.style.display = "none";
  }
});
prev4.addEventListener("click", e => {
  carousel4.scrollBy(-(width + gap4), 0);
  if (carousel4.scrollLeft - width - gap4 <= 0) {
    prev4.style.display = "none";
  }
  if (!content4.scrollWidth - width - gap4 <= carousel4.scrollLeft + width) {
    next4.style.display = "flex";
  }
});

window.addEventListener("resize", e => (width = carousel4.offsetWidth));
