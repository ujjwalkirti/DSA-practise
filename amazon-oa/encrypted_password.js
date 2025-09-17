

function checkPassword(new_password, old_password) {
    let first_index = 0;
    let generated_string = '';
    if (new_password.indexOf(old_password[0]) !== -1) {
        first_index = new_password.indexOf(old_password[0]);
    } else {
        first_index = new_password.indexOf(old_password[0].charCodeAt(0) - 1);
        if (first_index === -1) {
            return "No";
        }
    }

    let old_index = 1;
    generated_string += new_password[first_index];
    for (let i = first_index + 1; i < new_password.length; i++) {
        if (new_password[i].charCodeAt(0) == old_password[old_index].charCodeAt(0)) {
            generated_string += new_password[i];
            old_index++;
        } else if (new_password[i].charCodeAt(0) + 1 == old_password[old_index].charCodeAt(0)){
            generated_string += old_password[old_index];
            old_index++;
        }
        // length check
        if (generated_string.length >= old_password.length) {
            break;
        }
    }

    if (generated_string !== old_password) {
        return "No";
    } else {
        return "Yes";
    }

}

function main() {
    const new_passwords = ['baacbab', 'accdb', 'baacba'];
    const old_passwords = ['abdbc', 'ach', 'abb'];
    for (let i = 0; i < new_passwords.length; i++) {
        console.log(checkPassword(new_passwords[i], old_passwords[i]), "\n");
    }
}

main()
