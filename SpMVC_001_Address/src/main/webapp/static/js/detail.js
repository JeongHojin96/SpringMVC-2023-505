document.addEventListener("DOMContentLoaded", () => {
  const btn_list = document.querySelector("button.detail.list");
  const btn_update = document.querySelector("button.detail.update");
  const btn_delete = document.querySelector("button.detail.delete");

  btn_list?.addEventListener("click", () => {
    document.location.href = `${rootPath}/`;
  });

  btn_update?.addEventListener("click", (e) => {
    const id = e.target.dataset.id;
    document.location.href = `${rootPath}/update?id=${id}`;
  });

  btn_delete?.addEventListener("click", (e) => {
    // button tag 가 가장 중앙에 있기 떄문에
    // click event e.target 은 delete button 이 된다.
    const btn = e.target;
    const id = btn.dataset.id;

    if (confirm("삭제한 데이터는 복구 할 수 없습니다.\n정말 삭제할까요?")) {
      document.location.replace(`${rootPath}/delete?id=${id}`);
    }
  });
});
