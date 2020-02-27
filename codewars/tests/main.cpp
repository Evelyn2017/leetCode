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


std:: ostream& operator << (std::ostream &strm, const Token& token) {
    return strm<<"Token <"<<token.type << ", "<<token.value<<">"<<endl;
}

void token_type_cheat_sheet() {
    cout<<"-----------------------------------------------------------"<<endl;
    cout<<NUMBER << "        "<<NAME <<"      "<<LBRACE <<"      "<<RBRACE <<"       "<<LPAREN<<"     "<<RPAREN <<"      " <<ARROW << "     " <<COMMA <<"     "<<SEMICOLON<<endl;
    cout<<"NUMBER   "<<"NAME   "<<"{ "<<"     }" << "       ("<<"     )"<<"      -> "<<"   ,"<<"     ;"<<endl;
    cout<<"-----------------------------------------------------------"<<endl;
}

const char* transpile (const char* str) {
    Transpiler t = Transpiler(str);
    const char* res = t.function();
    if (res)
        return res;
//        return "1";
    return "";
}


// fun() => fun()
// fun(a) => fun(a)
// fun(a, b) => fun(a,b)
// {}() => (){}() -
// fun {} => fun((){}) --
// fun(a, {}) => fun(a,(){}) --
// fun(a) {} => fun(a,(){}) --
// fun {a -> a} => fun((a){a;})
// {a -> a}(1) => (a){a;}(1)
// fun { a, b -> a b } => fun((a,b){a;b;})
// {a, b -> a b} (1, 2) => (a,b){a;b;}(1,2)
// f { a } => f((){a;})
// f { a -> } => f((a){})
//int main() {
//    token_type_cheat_sheet();
//    const char* line1 = "fun()";
//    const char* line2 = "fun(a)";
//    const char* line3 = "fun(a, b)";
//    const char* line4 = "{}()";
//    const char* line5 = "fun {}";
//    const char* line6 = "fun(a, {})";
//    const char* line7 = "fun(a) {}";
//    const char* line8 = "fun {a -> a}";
//    const char* line9 = "{a -> a}(1)";
//    const char* line10 = "fun { a, b -> a b }";
//    const char* line11 = "{a, b -> a b} (1, 2)";
//    const char* line12 = "f { a }";
//    const char* line13 = "f { a -> }";
//    cout<<" 1: "<<line1 <<"\t\t\t\t\t"<<(string)transpile(line1)<< "\t\t\t\tfun()"<< endl;
//    cout<<" 2: "<<line2 <<"\t\t\t\t\t"<<(string)transpile(line2)<< "\t\t\t\tfun(a)"<<endl;
//    cout<<" 3: "<<line3 <<"\t\t\t\t"<<(string)transpile(line3)<< "\t\t\tfun(a,b)"<<endl;
//    cout<<" 4: "<<line4 <<"\t\t\t\t\t"<<(string)transpile(line4)<< "\t\t\t\t(){}()"<<endl;
//    cout<<" 5: "<<line5 <<"\t\t\t\t\t"<<(string)transpile(line5)<< "\t\t\tfun((){})"<<endl;
//    cout<<" 6: "<<line6 <<"\t\t\t\t"<<(string)transpile(line6)<< "\t\t\tfun(a,(){})"<<endl;
//    cout<<" 7: "<<line7 <<"\t\t\t\t"<<(string)transpile(line7)<< "\t\t\tfun(a,(){})"<<endl;
//    cout<<" 8: "<<line8 <<"\t\t\t"<<(string)transpile(line8)<< "\t\tfun((a){a;})"<<endl;
//    cout<<" 9: "<<line9 <<"\t\t\t\t"<<(string)transpile(line9)<< "\t\t\t(a){a;}(1)"<<endl;
//    cout<<"10: "<<line10 <<"\t\t"<<(string)transpile(line10)<< "\tfun((a,b){a;b;})"<<endl;
//    cout<<"11: "<<line11 <<"\t"<<(string)transpile(line11)<< "\t(a,b){a;b;}(1,2)"<<endl;
//    cout<<"12: "<<line12 <<"\t\t\t\t\t"<<(string)transpile(line12)<< "\t\t\tf((){a;})"<<endl;
//    cout<<"13: "<<line13 <<"\t\t\t\t"<<(string)transpile(line13)<< "\t\t\tf((a){})"<<endl;
//
//    const char* s = "f(a,b){a->a}";
//
//    cout <<(string)transpile(s)<<endl;
//    return 0;
//}


int main() {

}
