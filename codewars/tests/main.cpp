//
//  main.cpp
//  codewars
//
//  Created by Evelyn on 2020/2/24.
//  Copyright © 2020 Evelyn. All rights reserved.
//


#include <iostream>
#include "../include/Transpiler.hpp"

using namespace std;

// fun() => fun()
// fun(a) => fun(a)
// fun(a, b) => fun(a,b)
// {}() => (){}()
// fun {} => fun((){})
// fun(a, {}) => fun(a,(){})
// fun(a) {} => fun(a,(){})
// fun {a -> a} => fun((a){a;})
// {a -> a}(1) => (a){a;}(1)
// fun { a, b -> a b } => fun((a,b){a;b;})
// {a, b -> a b} (1, 2) => (a,b){a;b;}(1,2)
// f { a } => f((){a;})
// f { a -> } => f((a){})
std:: ostream& operator << (std::ostream &strm, const Token& token) {
    return strm<<"Token <"<<token.type << ", "<<token.value<<">"<<endl;
}

void token_type_cheat_sheet() {
    cout<<"-----------------------------------------------------------"<<endl;
    cout<<NUMBER << "        "<<NAME <<"      "<<LBRACE <<"      "<<RBRACE <<"       "<<LPAREN<<"     "<<RPAREN <<"      " <<ARROW << "     " <<COMMA <<"     "<<SEMICOLON<<endl;
    cout<<"NUMBER   "<<"NAME   "<<"{ "<<"     }" << "       ("<<"     )"<<"      -> "<<"   ,"<<"     ;"<<endl;
    cout<<"-----------------------------------------------------------"<<endl;
}

int main() {
    
    token_type_cheat_sheet();
    string line = "fun (a) {}";
    Transpiler t = Transpiler(line);
    cout << t.function()<<endl;
    return 0;
}
