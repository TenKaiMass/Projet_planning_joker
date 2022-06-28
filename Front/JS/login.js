function login_ok() {
  const choix = document.getElementById("my_id").value;
  url = "";
  console.log(choix);
  switch (choix) {
    case "admin":
      url = "index_admin.html";
      break;
    case "membre":
      url = "index_membre.html";
      break;
    case "responsable":
      url = "index_responsable.html";
      break;
    default:
      console.log("ce n'est pas un role existant");
  }
  const link = document.createElement("a");
  link.href = url;
  link.target = "_blank";
  document.body.appendChild(link);
  link.click();
}

