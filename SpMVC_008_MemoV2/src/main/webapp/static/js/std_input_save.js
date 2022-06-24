const st_num_fetchV2 = async (st_num) => {
  let ret = false;
  const res = await fetch(`${rootPath}/student/st_num_check?st_num=${st_num}`);
  const result = await res.text();
  if (result === "USE") {
    ret = false;
  } else {
    ret = true;
  }
  return ret;
};

const st_num_fetch = (st_num) => {
  let ret = false;
  fetch(`${rootPath}/student/st_num_check?st_num=${st_num}`)
    .then((res) => res.text())
    .then((result) => {
      if (result === "USE") {
        alert("이미 등록된 학번임둥\n다시 입력해야함둥");
        ret = false;
      } else {
        alert("사용 가능한 학번임둥");
        ret = true;
      }
    }); // end fetch
  return ret;
}; // end st_num_fetch()

const save_cb = async () => {
  const st_num = document.querySelector("input[name='st_num']");
  const st_name = document.querySelector("input[name='st_name']");
  const st_dept = document.querySelector("input[name='st_dept']");
  const st_grade = document.querySelector("input[name='st_grade']");
  const st_addr = document.querySelector("input[name='st_addr']");
  const st_tel = document.querySelector("input[name='st_tel']");

  if (st_num.value === "") {
    alert("학번은 반드시 입력해야 함둥");
    st_num.focus();
    return false;
  }

  const st_num_yes = await st_num_fetchV2(st_num.value);
  console.log("st_num_yes :", st_num_yes);

  if (!st_num_yes) {
    alert("이미 등록된 학번임둥\n 다시 입력해야함둥");
    st_num.value = "";
    st_num.focus();
    return false;
  }

  if (st_name.value === "") {
    alert("이름은 반드시 입력해야함둥");
    st_name.focus();
    return false;
  }

  if (st_dept.value === "") {
    alert("학과는 반드시 입력해야함둥");
    st_dept.focus();
    return false;
  }

  if (st_grade.value === "") {
    alert("학년은 반드시 입력해야함둥");
    st_grade.focus();
    return false;
  }

  const num_grade = Number(st_grade.value);

  if (!num_grade) {
    alert("학년은 숫자로만 입력해야함둥");
    st_grade.value = "";
    st_grade.focus();
    return false;
  }

  if (num_grade < 1 || num_grade > 4) {
    alert("학년은 1~4 범위내에서 입력해야함둥");
    st_grade.value = "";
    st_grade.focus();
    return false;
  }

  if (st_tel.value === "") {
    alert("전화번호는 반드시 입력해야함둥");
    st_tel.focus();
    return false;
  }
  if (st_addr.value === "") {
    alert("주소는 반드시 입력해야함둥");
    st_addr.focus();
    return false;
  }

  const form = document.querySelector("form");
  form.submit();
};
