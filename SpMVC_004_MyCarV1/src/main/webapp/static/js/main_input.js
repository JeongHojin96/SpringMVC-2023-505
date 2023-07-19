const INPUT_INDEX = {
  C_CARNUM: 0,
  C_QTY: 1,
  C_USERNAME: 2,
  C_SDATE: 3,
  C_STIME: 4,
};

document.addEventListener("DOMContentLoaded", () => {
  const main_form = document.querySelector("form.main");

  const formEnterHandler = (e) => {
    const target = e.target;
    if (e.keyCode === 13 && target.tagName === "INPUT") {
      const input_name = target["name"].toUpperCase();
      const input_index_num = INPUT_INDEX[input_name];
      //   alert(input_index_num);
      if (input_index_num < Object.keys(INPUT_INDEX).length - 1) {
        document.querySelectorAll("input")[input_index_num + 1].focus();
      }
    }
  };
  document.addEventListener("keydown", formEnterHandler);
  document.querySelector("input[name='c_carnum']").focus();
});
