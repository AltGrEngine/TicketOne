const gap3 = 16;

const carousel3 = document.getElementById("carousel3"),
  content3 = document.getElementById("content3"),
  next3 = document.getElementById("next3"),
  prev3 = document.getElementById("prev3");

next3.addEventListener("click", e => {
  carousel3.scrollBy(width + gap3, 0);
  if (carousel3.scrollWidth !== 0) {
    prev3.style.display = "flex";
  }
  if (content3.scrollWidth - width - gap3 <= carousel3.scrollLeft + width) {
    next3.style.display = "none";
  }
});
prev3.addEventListener("click", e => {
  carousel3.scrollBy(-(width + gap3), 0);
  if (carousel3.scrollLeft - width - gap3 <= 0) {
    prev3.style.display = "none";
  }
  if (!content3.scrollWidth - width - gap3 <= carousel3.scrollLeft + width) {
    next3.style.display = "flex";
  }
});

window.addEventListener("resize", e => (width = carousel3.offsetWidth));
