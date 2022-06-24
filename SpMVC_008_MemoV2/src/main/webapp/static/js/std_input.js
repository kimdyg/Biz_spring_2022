const std_num_check_cb = () => {
  const st_num = document.querySelector("input[name='st_num']");
  if (st_num.value === "") {
    alert("중복검사를 하려면 학번을 먼저 입력해야함둥");
    st_num.focus();
    return false;
  }
  if (!st_num_fetch(st_num.value)) {
    st_num.focus();
  }
};

document.addEventListener("DOMContentLoaded", () => {
  const std_num_check = document.querySelector("button.std-num-check");

  if (std_num_check) {
    std_num_check.addEventListener("click", std_num_check_cb); // end callback
  }
  const std_save = document.querySelector("button.std-save");
  if (std_save) {
    std_save.addEventListener("click", save_cb);
  }
});
