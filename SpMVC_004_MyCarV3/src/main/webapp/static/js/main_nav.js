document.addEventListener("DOMContentLoaded", () => {
  const nav = document.querySelector("nav.main");
  const nav_login = document.querySelector("li.login");
  const nav_join = document.querySelector("li.join");

  /*
    event 핸들러의 매개변수(e)
    e.currentTarget과 e.target 속성이 기본으로 포함되어 있다.
    이때 e.currentTarget 은 event 핸들러가 부착된 tag(nav.main) 이고
    e.target 은 event 버블링에 의해 가장 안쪽에서 실제 event 가 적용되는 tag(li)

  */
  const navClickHandler = (e) => {
    const current = e.currentTarget;
    const target = e.target;

    if (target.tagName === "LI") {
      const targetClassName = target.className;
      let URL = `${rootPath}` + targetClassName;
      const USER_URL = "login join mypage logout";

      if (targetClassName === "home") {
        URL = `${rootPath}`;
      } else if (USER_URL.indexOf(targetClassName) > -1) {
        URL = `${rootPath}user/` + targetClassName;
      }
      //   } else if (targetClassName === "mycar") {
      //     URL += targetClassName;
      //   } else if (targetClassName === "tarcho") {
      //     alert("tarcho");
      //   }
      document.location.href = URL;
    }
    // event 버블링 을 역으로 활용하여
    // 한개의 event 를 설정하여 할일들 처리하기
  };
  nav?.addEventListener("click", navClickHandler);

  // 개별적인 LI tag 에 click event 를 설정하여
  // nav 을 선택했을때 할일들 지정
  //   nav_login?.addEventListener("click", () => {
  //     alert("login");
  //   });

  //   nav_join?.addEventListener("click", () => {
  //     alert("join");
  //   });
});
