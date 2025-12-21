function func(delay) {
    return new Promise((res, rej) => {
        setTimeout(() => res({ a: 1, b: ["a", "b"] }), delay)
    })
}

func(1000).then((data) => console.log(`5 sec has passed has passed and data is ${JSON.stringify(data)}`));
