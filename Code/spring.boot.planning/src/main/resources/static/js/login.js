function login_ok() {
  const choix = document.getElementById("my_id").value;
  url = "";
  console.log(choix);
  switch (choix) {
    case "admin":
      url = "admin";
      break;
    case "membre":
      url = "membre";
      break;
    case "responsable":
      url = "responsable";
      break;
    default:
      console.log("rôle inexistant");
  }
  const link = document.createElement("a");
  link.href = url;
  link.target = "_blank";
  document.body.appendChild(link);
  link.click();
}

