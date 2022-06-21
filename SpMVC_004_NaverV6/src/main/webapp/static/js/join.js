document.addEventListener("DOMContentLoaded", () => {
  const username = document.querySelector("#username");
  const password = document.querySelector("#password");
  const re_password = document.querySelector("#re_password");
  const email = document.querySelector("#email");
  const btn_join = document.querySelector("#btn-join");

  const div_index = {
    username: 0,
    password: 1,
    re_password: 2,
    email: 3,
    name: 4,
    nickname: 5,
  };

  const error_divs = document.querySelectorAll("div.error");

  // 문자, 숫자, 특수문자가 포함된 8자리 ~ 15자리까지 비밀번호 문자열 검사패턴
  const passRule2 =
    /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
  // 문자와 숫자가 포함되어있고 6자리부터 12자리까지의 문자열 검사패턴. 비밀번호설정
  const passRule = /^[A-Za-z0-9]{6,12}$/;

  const emailRule =
    /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

  // 화면이 모두 그려지면 username input box에 포커싱하기
  username?.focus();

  const error_msg = (div, message) => {
    div.classList.remove("w3-text-blue");
    div.classList.add("w3-text-red");
    div.innerText = message;
  };
  const ok_msg = (div, message) => {
    div.classList.remove("w3-text-red");
    div.classList.add("w3-text-blue");
    div.innerText = message;
  };

  /*
  input box 에서 focus 가 벗어났을때 발생하는 event
  focusout,blur
  focusout 은 이벤트 버블링이 심하게 발생한다
  JS 코드에서는 주로 blur
  */
  username?.addEventListener("blur", (e) => {
    const username_div = error_divs[div_index.username];
    const current = e.currentTarget;
    if (current.value === "") {
      const msg = "* USER NAME 은 반드시 입력하세요";
      error_msg(username_div, msg);

      current.focus();
      return false;
    }

    // 중복검사 수행
    fetch(`${rootPath}/user/idcheck/${current.value}`)
      .then((res) => res.text())
      .then((result) => {
        // 서버에서 OK 문자열을 보내면 체크한 Username 은 사용해도 된다 라는
        if (result === "OK") {
          const msg = " * 사용가능한 USER NAME 입니다";
          ok_msg(username_div, msg);
        } else {
          username_div.classList.remove("w3-text-blue");
          username_div.classList.add("w3-text-red");
          username_div.innerText = " * 이미 가입된 USER NAME 입니다";
          username.focus();
        }
      });
  }); // end username event

  password?.addEventListener("input", (e) => {
    const current = e.currentTarget;
    const error = error_divs[div_index.password];
    if (!passRule2.test(current.value)) {
      error.classList.remove("w3-text-red");
      error.classList.add("w3-text-blue");
      error.innerText = " * 굿 좝 엑설런트!!";
    } else {
      error.classList.remove("w3-text-blue");
      error.classList.add("w3-text-red");
      error.innerText =
        " * 비밀번호가 규칙에 맞지 않습니다(특수,영문,숫자포함 8 ~15)";
    }
  });

  re_password?.addEventListener("input", (e) => {
    const current = e.currentTarget;
    const error = error_divs[div_index.re_password];

    if (current.value === password?.value) {
      error.classList.remove("w3-text-red");
      error.classList.add("w3-text-blue");
      error.innerText = " * 비밀번호 확인이 일치합니다";
    } else {
      error.classList.remove("w3-text-blue");
      error.classList.add("w3-text-red");
      error.innerText = " * 비밀번호 확인이 일치하지 않습니다";
    }
  }); //end re_password

  email?.addEventListener("input", (e) => {
    const error = error_divs[div_index.email];
    const current = e.currentTarget;
    if (emailRule.test(current.value)) {
      error.classList.remove("w3-text-red");
      error.classList.add("w3-text-blue");
      error.innerText = " * 이메일 양식 검사 완료!";
    } else {
      error.classList.remove("w3-text-blue");
      error.classList.add("w3-text-red");
      error.innerText = " * 이메일 양식 확인바람!";
      // email 양식 검사를 통과하지 못하면 다음 코드를 실행하지 않도록
      return false;
    } // 양식 검사 end
    fetch(`${rootPath}/user/emailcheck?email=${current.value}`)
      .then((res) => res.text())
      .then((result) => {
        if (result === "OK") {
          error.classList.remove("w3-text-red");
          error.classList.add("w3-text-blue");
          error.innerText = " * 사용 가능";
        } else {
          error.classList.remove("w3-text-red");
          error.classList.add("w3-text-blue");
          error.innerText = " * 사용 불가능";
        }
      });
  });

  btn_join?.addEventListener("click", () => {
    if (username.value === "") {
      alert("USER NAME 은 반드시 입력하세요");
      username.focus();
      return false;
    }

    if (username.value.length > 20) {
      alert("USER NAME 은 20자 이내로 입력하세요");
      username.focus();
      return false;
    }

    // ID 와 PASSWORD 대문자로 변형하여 비교하고 같은지 비교
    if (username.value.toUpperCase() === password.value.toUpperCase()) {
      alert("USER NAME 과 비밀번호는 같을 수 없습니다.");
      password.focus();
      return false;
    }

    // 문자, 숫자, 특수문자가 포함된 8자리 ~ 15자리까지 비밀번호 문자열 검사패턴
    const passRule2 =
      /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
    // 문자와 숫자가 포함되어있고 6자리부터 12자리까지의 문자열 검사패턴. 비밀번호설정
    const passRule = /^[A-Za-z0-9]{6,12}$/;

    // password.value 의 값이 패턴에 일치하지 않으면
    if (passRule2.test(password.value) === false) {
      alert(
        "비밀번호는 특수문자, 영문자, 숫자 포함 \n8자리 ~ 15자리 까지 입력하세요"
      );
      password.focus();
      return;
    }

    if (re_password.value === "") {
      alert("비밀번호 확인을 입력해 주세요");
      re_password.focus();
      return false;
    }
    if (password.value !== re_password.value) {
      alert("비밀번호 확인 값이 일치하지 않습니다");
      password.value == "";
      re_password.value == "";
      password.focus();
      return false;
    }

    const emailRule =
      /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

    if (!emailRule.test(email.value)) {
      alert("이메일 형식이 잘못되었습니다 다시입력 해주세요");
      email.focus();
      return false;
    }
    document.querySelector("form.join")?.submit();
  });
});
