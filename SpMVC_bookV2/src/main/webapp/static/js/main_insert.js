const ERROR_MESSAGE = {
  CODE: "* 코드 입력",
  NAME: "* 제목 입력",
  AUTHER: "* 저자 입력",
  YEAR: "* 구입 연도 입력",
  RPRICE: "* 대여 가격 입력",
};

document.addEventListener("DOMContentLoaded", () => {
  const insert_code = document.querySelector("#b_code");
  const insert_name = document.querySelector("#b_name");
  const insert_auther = document.querySelector("#b_auther");
  const insert_year = document.querySelector("#b_year");
  const insert_rprice = document.querySelector("#b_rprice");
  const insert_iprice = document.querySelector("#b_iprice");

  const err_code = document.querySelector("div.error.code");
  const err_name = document.querySelector("div.error.name");
  const err_auther = document.querySelector("div.error.auther");
  const err_year = document.querySelector("div.error.year");
  const err_rprice = document.querySelector("div.error.rprice");

  const btn_save = document.querySelector("#btn_save");

  const err_clear = () => {
    for (let box of err_box_list) {
      box?.classList.remove("on");
    }
  };

  insert_code?.select();

  insert_code?.addEventListener("blur", async () => {
    err_clear();
    if (!err_message(insert_code, err_code, ERROR_MESSAGE.CODE)) {
      return false;
    }
    const code = insert_code.value;
    const res = await fetch(`${rootPath}/book_check?code=${code}`);
    const json = await res.json();
    if (json.b_code === "NOT") {
      err_code.classList.add("on");
      err_code.innerHTML = "* this is new code";
      insert_iprice.value = "";
      insert_rprice.value = "";
    } else {
      insert_rprice.value = json.b_rprice;
      insert_iprice.value = json.b_iprice;
    }
  });

  insert_name?.addEventListener("blur", () => {
    err_clear();
    if (!err_message(insert_name, err_name, ERROR_MESSAGE.NAME)) {
      return false;
    }
  });

  insert_auther?.addEventListener("blur", () => {
    err_clear();
    if (!err_message(insert_auther, err_auther, ERROR_MESSAGE.AUTHER)) {
      return false;
    }
  });

  insert_year?.addEventListener("blur", () => {
    err_clear();
    if (!err_message(insert_year, err_year, ERROR_MESSAGE.YEAR)) {
      return false;
    }
  });

  insert_rprice?.addEventListener("blur", () => {
    err_clear();
    if (!err_message(insert_rprice, err_rprice, ERROR_MESSAGE.RPRICE)) {
      return false;
    }
  });

  btn_save?.addEventListener("click", () => {
    if (
      err_message(insert_code, err_code, ERROR_MESSAGE.code) &&
      err_message(insert_name, err_name, ERROR_MESSAGE.NAME) &&
      err_message(insert_auther, err_auther, ERROR_MESSAGE.AUTHER) &&
      err_message(insert_year, err_year, ERROR_MESSAGE.YEAR) &&
      err_message(insert_rprice, err_rprice, ERROR_MESSAGE.RPRICE)
    ) {
      document.querySelector("form.main").submit();
    }
    return false;
  });
});
