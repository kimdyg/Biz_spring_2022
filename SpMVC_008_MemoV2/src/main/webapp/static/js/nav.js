document.addEventListener("DOMContentLoaded", () => {
  const nav = document.querySelector("nav");
  if (nav) {
    nav.addEventListener("click", (e) => {
      const target = e.target;
      const navText = target.innerText;

      let url = `${rootPath}`;
      if (navText === "학생정보") {
        url += "/student";
      } else if (navText === "성적정보") {
        alert("성적정보를 입력합니다");
      } else if (navText === "로그인") {
        alert("로그인 창을 띄웁시다");
      } else if (navText === "회원가입") {
        alert("아직 회원가입은 받지 않습니다");
      }
      document.location.href = url;
    });
  }
});
