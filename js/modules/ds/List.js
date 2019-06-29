class List {
  constructor() {
    this.items = [];
  }

  length() {
    return this.items.length;
  }

  size() {
    return this.length();
  }

  isEmpty() {
    return this.items.length === 0;
  }

  push(val) {
    this.items.push(val);
  }

  add(val) {
    this.push(val);
  }

  offer(val) {
    this.push(val);
  }

  shift() {
    return this.items.shift();
  }

  poll() {
    return this.shift();
  }

  peek() {
    return this.items[0];
  }

  pop() {
    return this.items.pop();
  }

  removeLast() {
    return this.pop();
  }

  static of(array) {
    const list = new List();
    list.items = array;
    return list;
  }
}

module.exports = List;
