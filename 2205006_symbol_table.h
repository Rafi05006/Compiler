#ifndef SYMBOL_TABLE_H
#define SYMBOL_TABLE_H

#include <iostream>
#include <string>
#include <vector>

using namespace std;

struct FunctionInfo {
    string returnType;
    vector<string> paramTypes;
    bool isDefined = false;
};

struct ArrayInfo {
    int size = 0;
};

class SymbolInfo {
private:
    string name;
    string varType;

public:
    SymbolInfo* next = nullptr;

    bool isArray = false;
    bool isFunction = false;
    ArrayInfo* arrayInfo = nullptr;
    FunctionInfo* functionInfo = nullptr;

    SymbolInfo();
    SymbolInfo(const string& n, const string& t);

    string getName() const;
    void setName(const string& n);

    string getType() const;
    void setType(const string& t);

    ~SymbolInfo();
};

class ScopeTable {
private:
    static const int TOTAL_BUCKETS = 30;
    SymbolInfo* table[TOTAL_BUCKETS];
    string id;

public:
    ScopeTable* parentScope = nullptr;

    int childrenCount = 0;

    ScopeTable();

    static unsigned int hashName(const string& s);

    SymbolInfo* insert(const string& name, const string& type);
    SymbolInfo* lookup(const string& name);

    void setId(const string& newId);
    string getId() const;

    void print(ostream& out) const;

    ~ScopeTable();
};

class SymbolTable {
private:
    ScopeTable* currentScope;

public:
    SymbolTable();

    void enterScope();
    void exitScope(ostream& out);
    void discardScope();

    SymbolInfo* insert(const string& name, const string& type);
    SymbolInfo* lookup(const string& name);
    SymbolInfo* lookupCurrentScopeOnly(const string& name);

    void printCurrentScope(ostream& out) const;

    ~SymbolTable();
};

#endif