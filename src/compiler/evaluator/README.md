
# Calculator 07

A prototype of a calculator runtime that evolved into a python interpreter.

## Example Program

```py
def calc_space(side):
    return side * side

a_side = 5
space = calc_space(a_side)

print("space =", space)
```

## Incrementation Features

- `SourceNode`s now have `addMeta` which allows to attach some parser information to the nodes.
  - Like `line`, `column` and `filename`.
  - This is useful for both error reporting and printing the source-tree.
- `SourceNode` when converted to a string now displays a fancy/pretty formatted text view of the tree.
  - The tree also includes the symbols tables if they are analyzed.

## The current plan for next generations

- For Generation 7:
  - ~~Add `line` and `column` parameters to all nodes.~~ Done.
  - ~~Implement a human-readable format for printing the source-tree.~~
  - Create source-tree node for all the currently available grammar, but with no execution implementation.
- For Generation 8:
  - Implement a draft of the boolean builtin type.
  - Support comparison expressions.
  - Support conditional statements and loops?
  - Support lists?
- For Generation 9:
  - Support the `global` and `nonlocal` keywords.

## The old plan for next generations

- ~~For Generation `N+1`:~~ Done.
  - ~~Introduce `StatementsBlock` which groups statements together.~~
    - ~~This is to have an abstracted logic for executing the group of statements.~~
      - ~~So it can be reused between functions, loops, conditional statements, etc...~~
  - ~~Add `return` statements support.~~
- For Generation `N+2`:
  - ~~Have a parent class for all the source tree nodes.~~ Done.
  - ~~Support the node visitor pattern.~~ Done.
  - ~~Generate symbols tables for each scope (by utilizing the nodes visitor pattern).~~ Done.
  - Support the `global` and `nonlocal` keywords.
  - ~~Fix the early access issue of the local variables.~~ Done.
- For Generation `N+3`?
  - Implement a draft of the boolean builtin type.
  - Support comparison expressions.
  - Look into `str` and `repr` logic.
  - Support conditional statements and loops?
- For Generation `N+4`?
  - Collect location information of the nodes, so tracebacks can be made for error reporting.
  - Support exceptions and look for doing error reporting?

## Supported Statements & Expressions

- Arithmetic Expressions.
- Literal Values.
- Identifiers (accessing a variable's content).
- Program (a sequence of expressions).
- Assignment Expressions.
- Functions declaration.
- Function call.
- Return Statement.

## Implementation Constraints

- All expressions return a value.
- All values are `PyObject` and using polymorphism other types can be used.
- Operators precedence has to be implemented by the parser.
- Undefined variables access throws exceptions.
- Undefined function call throws exceptions.
- Assignment expressions return the assigned value.

## Concerns

- How to handle runtime exceptions with this structure?
- ~~It's necessary to release the `Double` constraint in the next generation
and introduce statements support.~~ Done :)
- ~~In the following sample, the variable in the whole function scope is considered local:~~ Done.
```python
my_var=5

def my_func():
    print(my_var) # throws a runtime error for accessing the variable before initialization.
    my_var=5
    print(my_var)

my_func()

# This might give a hint that a function must
# scan for the identifiers inside its scope?
# This might be what's known as creating a "symbols table".
```
- ~~How to detect the type of objects in Python's world?~~ Done.

### Things TODO

- [ ] Handle default values for functions parameters.
- [ ] Support named parameters.
- [ ] Support variadic parameters (`*` and `**`).
- [x] ~~Introduce statements support (that evaluate to no value).~~ Done.
- [x] ~~Introduce mixed values types support.~~ Done.
- [ ] Support `global` keyword.
  - That in turn asks for the support of "symbols table".
- [ ] Implement the rest of builtins.
  - [Builtin Constants](https://docs.python.org/3/library/constants.html)
  - [Builtin Types](https://docs.python.org/3/library/stdtypes.html)
  - [Builtin Exceptions](https://docs.python.org/3/library/exceptions.html)
  - [Builtin Functions](https://docs.python.org/3/library/functions.html)
- [ ] Continue supporting the special methods of the [Data Model](https://docs.python.org/3/reference/datamodel.html).
- [ ] The TODO statements within the code.

#### Even Further

- Flow control: `if`, `elif`, `else`, `for`, `while`.

## Conclusions

- ~~The `return` statement will be tricky to implement.~~ Done :)
  - ~~Especially when returning from within nested loops inside a function.~~
    - ~~This also reminds of the `break` and `continue` keywords.~~
  - ~~The logic of running a group of expressions within a context should be unified.~~
    - ~~It would have a mechanism to terminate the current iteration of the group execution.~~
- Python is a pretty language that could be the most dynamic/flexible interpreter.
