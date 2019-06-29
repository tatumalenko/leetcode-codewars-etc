fn num_jewels_in_stones(j: String, s: String) -> i32 {
    let mut n = 0;

    for c in j.chars() {
        //n += s.matches(c).count();
        for ss in s.chars() {
            if c == ss {
                n += 1;
            }
        }
    }

    n as i32
}

fn main() {
    println!(
        "{}",
        num_jewels_in_stones(String::from("aA"), String::from("aAAbbbb"))
    );
}