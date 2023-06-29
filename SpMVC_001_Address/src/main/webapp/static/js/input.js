// HTML DOM 기반의 JS 코드 시작점

document.addEventListener("DOMContentLoaded", () => {
  // DOM 객체(tag 객체)
  const addr_input = document.querySelector("form.input");
  const btn_input = document.querySelector("button.input");
  const btn_list = document.querySelector("button.list");

  const msg_box = document.querySelector("div.message");

  const input_id = document.querySelector("input[name='a_id']");

  // inline 익명(무명) 함수로 click event 설정
  btn_list?.addEventListener("click", (e) => {
    // alert("리스트 버튼 클릭");
    // 현재 화면에 보여줄 페이지 요청(위 주소창 변경?)
    document.location.href = `${rootPath}`;
  });

  // event call 함수를 선언하고
  const inputbuttonClickHandler = (e) => {
    // alert("추가 버튼 클릭");
    // JS 코드에서 form 에 포함하
    addr_input?.submit();
  };
  // 선언된 event call 함수를 사용하여 click event 선언
  btn_input?.addEventListener("click", inputbuttonClickHandler);

  input_id?.addEventListener("blur", (e) => {
    const value = e.target.value;
    const span_box = msg_box.querySelector("span");

    const idCheck_url = `${rootPath}/id_check?id=${value}`;

    if (!value) {
      msg_box.classList.remove("ok");
      msg_box.classList.add("error");
      span_box.innerHTML = "* ID를 입력해주세요";
      input_id.focus();
      return false;
    }

    fetch(idCheck_url)
      .then((Response) => Response.text())
      .then((result) => {
        if (result === "OK") {
          msg_box.classList.remove("error");
          msg_box.classList.add("ok");
          span_box.innerHTML = "* 사용가능한 ID 입니다.";
        } else if (result === "FAIL") {
          msg_box.classList.remove("ok");
          msg_box.classList.add("error");
          span_box.innerHTML = "* 이미 사용중인 ID 입니다.";
          input_id.focus();
        } else {
          msg_box.classList.remove("ok");
          msg_box.classList.add("error");
          span_box.innerHTML = "* 서버 오류. 알수없는 오류가 발생했습니다.";
          input_id.focus();
        }
      });
  });
});
