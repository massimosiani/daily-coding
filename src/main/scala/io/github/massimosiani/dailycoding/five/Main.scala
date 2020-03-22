package io.github.massimosiani.dailycoding.five

object Main extends App {

  def cons[A, B, C](a: A, b: B): ((A, B) => C) => C = {
    def pair(f: (A, B) => C): C = f(a, b)
    pair
  }

  def car[A, B](cons: ((A, B) => A) => A): A = cons((a, _) => a)

  def cdr[A, B](cons: ((A, B) => B) => B): B = cons((_, b) => b)
}
