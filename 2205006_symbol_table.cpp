#include "2205006_symbol_table.h"

// ------------------------------------------------------------
// SymbolInfo
// ------------------------------------------------------------

SymbolInfo::SymbolInfo() {}

SymbolInfo::SymbolInfo(const string& n, const string& t)
    : name(n), varType(t) {}

string SymbolInfo::getName() const {
    return name;
}

void SymbolInfo::setName(const string& n) {
    name = n;
}

string SymbolInfo::getType() const {
    return varType;
}

void SymbolInfo::setType(const string& t) {
    varType = t;
}

SymbolInfo::~SymbolInfo() {
    delete arrayInfo;
    delete functionInfo;
}


// ------------------------------------------------------------
// ScopeTable
// ------------------------------------------------------------

ScopeTable::ScopeTable() {
    for (int i = 0; i < TOTAL_BUCKETS; i++)
        table[i] = nullptr;
}

unsigned int ScopeTable::hashName(const string& s) {
    unsigned int sum = 0;

    for (unsigned char c : s)
        sum += c;

    return sum % TOTAL_BUCKETS;
}

SymbolInfo* ScopeTable::insert(
    const string& name,
    const string& type
) {
    unsigned int idx = hashName(name);

    SymbolInfo* entry = table[idx];

    while (entry != nullptr) {
        if (entry->getName() == name)
            return nullptr;

        entry = entry->next;
    }

    SymbolInfo* fresh = new SymbolInfo(name, type);

    if (table[idx] == nullptr) {
        table[idx] = fresh;
    }
    else {
        SymbolInfo* tail = table[idx];

        while (tail->next != nullptr)
            tail = tail->next;

        tail->next = fresh;
    }

    return fresh;
}

SymbolInfo* ScopeTable::lookup(const string& name) {
    unsigned int idx = hashName(name);

    SymbolInfo* entry = table[idx];

    while (entry != nullptr) {
        if (entry->getName() == name)
            return entry;

        entry = entry->next;
    }

    return nullptr;
}

void ScopeTable::setId(const string& newId) {
    id = newId;
}

string ScopeTable::getId() const {
    return id;
}

void ScopeTable::print(ostream& out) const {
    out << "ScopeTable # " << id << "\n";

    for (int i = 0; i < TOTAL_BUCKETS; i++) {

        SymbolInfo* entry = table[i];

        if (entry == nullptr)
            continue;

        out << " " << i << " --> ";

        while (entry != nullptr) {
            out << "< "
                << entry->getName()
                << " , ID > ";

            entry = entry->next;
        }

        out << "\n";
    }

    out << "\n";
}

ScopeTable::~ScopeTable() {

    for (int i = 0; i < TOTAL_BUCKETS; i++) {

        SymbolInfo* entry = table[i];

        while (entry != nullptr) {

            SymbolInfo* tmp = entry;
            entry = entry->next;

            delete tmp;
        }
    }
}


// ------------------------------------------------------------
// SymbolTable
// ------------------------------------------------------------

SymbolTable::SymbolTable() {

    currentScope = new ScopeTable();

    currentScope->setId("1");
}

void SymbolTable::enterScope() {

    currentScope->childrenCount++;

    ScopeTable* fresh = new ScopeTable();

    fresh->setId(
        currentScope->getId()
        + "."
        + to_string(currentScope->childrenCount)
    );

    fresh->parentScope = currentScope;

    currentScope = fresh;
}

void SymbolTable::discardScope() {

    if (currentScope == nullptr || currentScope->parentScope == nullptr)
        return;

    ScopeTable* tmp = currentScope;

    currentScope = currentScope->parentScope;

    delete tmp;
}

void SymbolTable::exitScope(ostream& out) {

    if (currentScope == nullptr)
        return;

    ScopeTable* walk = currentScope;

    while (walk != nullptr) {
        walk->print(out);
        walk = walk->parentScope;
    }

    ScopeTable* tmp = currentScope;

    currentScope = currentScope->parentScope;

    delete tmp;
}

SymbolInfo* SymbolTable::insert(
    const string& name,
    const string& type
) {
    return currentScope->insert(name, type);
}

SymbolInfo* SymbolTable::lookup(
    const string& name
) {
    ScopeTable* scope = currentScope;

    while (scope != nullptr) {

        SymbolInfo* entry =
            scope->lookup(name);

        if (entry != nullptr)
            return entry;

        scope = scope->parentScope;
    }

    return nullptr;
}

SymbolInfo* SymbolTable::lookupCurrentScopeOnly(
    const string& name
) {
    return currentScope->lookup(name);
}

void SymbolTable::printCurrentScope(
    ostream& out
) const {
    currentScope->print(out);
}

SymbolTable::~SymbolTable() {

    while (currentScope != nullptr) {

        ScopeTable* tmp = currentScope;

        currentScope =
            currentScope->parentScope;

        delete tmp;
    }
}