document.addEventListener("DOMContentLoaded", () => {
  const nav = document.querySelector("nav.main");
  const nav_booklist = document.querySelector("li.booklist");
  const nav_userlist = document.querySelector("li.userlist");

  const navClickHandler = (e) => {
    const current = e.currentTarget;
    const target = e.target;

    if (target.tagName === "LI") {
      const targetClassName = target.className;
      let URL = `${rootPath}` + targetClassName;
      const USER_URL = "dd";

      if (targetClassName === "home") {
        URL = `${rootPath}`;
      } else if (USER_URL.indexOf(targetClassName) > -1) {
        URL = `${rootPath}user/` + targetClassName;
      }

      document.location.href = URL;
    }
  };
  nav?.addEventListener("click", navClickHandler);
});
