const ERROR_MESSAGE = {
  CARNUM: "* 차량번호를 입력하세요.",
  QTY: "* 업무명은 반드시 입력해라",
  USERNAME: "* 이름 반드시 입력해라",
  SDATE: "* 시작 일자 반드시 입력해라",
  STIME: "* 시작 시간 반드시 입력해라",
  SKM: "* 시작 Km 반드시 입력해라",
};

document.addEventListener("DOMContentLoaded", () => {
  const input_carnum = document.querySelector("#c_carnum");
  const input_sdate = document.querySelector("#c_sdate");
  const input_stime = document.querySelector("#c_stime");
  const input_qty = document.querySelector("#c_qty");
  const input_username = document.querySelector("#c_username");
  const input_skm = document.querySelector("#c_skm");

  const err_box_list = document.querySelectorAll("div.error");

  const err_carnum = document.querySelector("div.error.c_carnum");
  const err_qty = document.querySelector("div.error.c_qty");
  const err_username = document.querySelector("div.error.c_username");
  const err_sdate = document.querySelector("div.error.c_sdate");
  const err_stime = document.querySelector("div.error.c_stime");
  const err_skm = document.querySelector("div.error.c_skm");

  const btn_save = document.querySelector("#btn_save");

  const err_clear = () => {
    for (let box of err_box_list) {
      box?.classList.remove("on");
    }
  };

  input_carnum?.select();

  input_carnum?.addEventListener("blur", async () => {
    err_clear();
    if (!err_message(input_carnum, err_carnum, ERROR_MESSAGE.CARNUM)) {
      return false;
    }
    const carnum = input_carnum.value;
    const res = await fetch(`${rootPath}/car_check?carnum=${carnum}`);
    const json = await res.json();
    if (json.c_carnum === "NOT") {
      err_carnum.classList.add("on");
      err_carnum.innerHTML = "* this is new carnum";
      input_skm.value = "";
    } else {
      input_skm.value = json.c_ekm;
    }
  });

  input_qty?.addEventListener("blur", () => {
    err_clear();
    if (!err_message(input_qty, err_qty, ERROR_MESSAGE.QTY)) {
      return false;
    }
  });

  input_sdate?.addEventListener("blur", () => {
    err_clear();
    if (!err_message(input_sdate, err_sdate, ERROR_MESSAGE.SDATE)) {
      return false;
    }
  });

  input_username?.addEventListener("blur", () => {
    err_clear();
    if (!err_message(input_username, err_username, ERROR_MESSAGE.USERNAME)) {
      return false;
    }
  });

  btn_save?.addEventListener("click", () => {
    if (
      err_message(input_carnum, err_carnum, ERROR_MESSAGE.CARNUM) &&
      err_message(input_qty, err_qty, ERROR_MESSAGE.QTY) &&
      err_message(input_username, err_username, ERROR_MESSAGE.USERNAME) &&
      err_message(input_sdate, err_sdate, ERROR_MESSAGE.SDATE)
    ) {
      document.querySelector("form.main").submit();
    }
    return false;
  });
});
