#include <iostream>
#include <fstream>
#include <cstring>
#include <string>
#include <ctime>
using namespace std;

struct Orario{
    int ora, minuto, secondo;
    bool am;
};

struct Data{
    int giorno, mese, anno;
};

bool number(string str, bool IoD) {
	if (IoD) { //true = int, false = double
		for (unsigned int j = 0; j < str.length(); j++)
			if (str[j] < '0' || str[j] > '9')
				return true;
	}
	else {
		for (unsigned int j = 0; j < str.length(); j++)
			if ((str[j] < '0' || str[j] > '9') && str[j] != '.')
				return true;
	}
	return false;
}

int limit(int month){
    switch(month){
        case 1: return 31;
        case 2: return 28;
        case 3: return 31;
        case 4: return 30;
        case 5: return 31;
        case 6: return 30;
        case 7: return 31;
        case 8: return 31;
        case 9: return 30;
        case 10: return 31;
        case 11: return 30;
        case 12: return 31;
    }
    return 0;
}

int curYear(){
    time_t current;
    time(&current);
    string year, all = ctime(&current);
    year = all.substr(all.length()-5, all.length()-1);
    return stoi(year);
}

int getInt(int valMin){
    int x;
    string str;
    do {
		cin >> str;
		if (number(str, true))
			cerr << "Non e' una cifra valida, riprova:\t";
		else{
			x = stoi(str);
			if (x <= valMin)
				cerr << "Valore non valido, riprova:\t";
		}
	} while (x <= valMin || number(str, true));
    return x;
}

void dates(int &YYYY, int &MM, int &GG, int x, string str){
    int s = 0;
    bool ex = false;
    string gg = "", mm = "", yyyy = "";
    for(unsigned int j = 0; j < str.length(); j++){
        if(str[j] == '/' || str[j] == '\\'){
            s++;
        }else switch(s){
            case 0: gg += str[j];break;
            case 1: mm += str[j];break;
            case 2: yyyy += str[j];break;
            default: ex = true;
        }
        if(ex)  break;
    }
    if(gg == "" || mm == "" || yyyy == ""){
        GG = 0;
        MM = 0;
        YYYY = 0;
        return;
    }
    YYYY = stoi(yyyy);
    if(x == 1){
        GG = stoi(gg);
        MM = stoi(mm);
    }else {
        MM = stoi(gg);
        GG = stoi(mm);
    }
}

bool good(string str, int x){
    int GG, MM, YYYY;
    dates(YYYY, MM, GG, x, str);
    if((GG > 31 || GG < 1) || (MM > 12 || MM < 1) || YYYY < curYear())
        return true;
    else if(GG > limit(MM))
        return true;
    return false;
}

Data getDateS(){
    Data x;
    string str;
    int scelta;
    bool ax;
    cout << "1) gg/mm/yyyy o 2) mm/gg/yyyy:\t";
    scelta = getInt(0);
    while(scelta < 1 || scelta > 2)
        scelta = getInt(0);
    cin.ignore();
    cout << "Data:\t";
    do{
        getline(cin, str);
        ax = good(str, scelta);
        if(ax)
            cerr << "Stringa non valida, riprova:\t";
    }while(ax);
    dates(x.anno, x.mese, x.giorno, scelta, str);
    return x;
}

Data getDate(){
    Data x;
    int scelta;
    cout << "1) Inserimento data manuale o 2) Inserimento stringa corrispondente alla data (gg/mm/yyyy...):\t";
    scelta = getInt(0);
    while(scelta < 1 || scelta > 2)
        scelta = getInt(0);
    if(scelta == 1){
        cout << "Inserire il numero corrispondente al mese:\t";
        cin >> x.mese;
        while (x.mese < 1 || x.mese > 12){
            cerr << "Mese non valido:\nRiprova:\t";
            cin >> x.mese;
        }
        cout << "Inserire il giorno:\t";
        cin >> x.giorno;
        while (x.giorno < 1 || x.giorno > limit(x.mese)){
            cerr << "Giorno non valido:\nRiprova:\t";
            cin >> x.giorno;
        }
        cout << "Inserisci l'anno:\t";
        cin >> x.anno;
        while (x.anno < curYear() || x.anno > curYear()+100){
            cerr << "Anno non valido (questo o entro 100 anni):\nRiprova:\t";
            cin >> x.anno;
        }
        cin.ignore();
    }else x = getDateS();
    return x;
}

Orario getTime(){
    Orario x;
    char am;
    cout << "Inserisci l'ora:\t";
    cin >> x.ora;
    while (x.ora < 0 || x.ora > 11){
        cerr << "Ora non valida:\nRiprova:\t";
        cin >> x.ora;
    }
    cout << "Inserisci il minuto:\t";
    cin >> x.minuto;
    while (x.minuto < 0 || x.minuto > 59){
        cerr << "Minuto non valido:\nRiprova:\t";
        cin >> x.minuto;
    }
    cout << "Inserisci il secondo:\t";
    cin >> x.secondo;
    while (x.secondo < 0 || x.secondo > 59){
        cerr << "Secondo non valido:\nRiprova:\t";
        cin >> x.secondo;
    }
    cin.ignore();
    cout << "Inserire M per mattina o S per sera:\t";
    cin >> am;
    if(am < 97) am += 32;
    while (am < 'a' || am > 'z'){
        cerr << "Scelta non valida:\nRiprova:\t";
        cin >> am;
        if(am < 97) am += 32;
    }
    if(am == 'm') 
        x.am = true;
    else
        x.am = false;
    return x; 
}

string allToString(string sog, string desc, string loc, bool day, Orario sT, Orario eT, Data sD, Data eD){
    string line = sog + ",", amS, amE, all;
    if(sT.am) amS = "AM"; else amS = "PM";
    if(eT.am) amE = "AM"; else amE = "PM";
    if(day) all = "TRUE"; else all = "FALSE";
    line += to_string(sD.mese) + "/" + to_string(sD.giorno) + "/" + to_string(sD.anno) + "," + to_string(sT.ora) + ":";
    line += to_string(sT.minuto) + ":" + to_string(sT.secondo) + " " + amS + "," + to_string(eD.mese) + "/" + to_string(eD.giorno);
    line += "/" + to_string(eD.anno) + "," + to_string(eT.ora) + ":" + to_string(eT.minuto) + ":" + to_string(eT.secondo);
    line += " " + amE + "," + all + "," + desc + "," + loc;
    return line;
}

string getData(){
    int selec, singleDay;
    string subject, desc, loc;
    bool allDay = false, singD = false;
    Orario sTime, eTime;
    Data sDate, eDate;
    cout << "Inserisci il soggetto dell'evento :\n";
    getline(cin, subject);
    cout << "Inserire 1 per segnare tutto il giorno:\t";
    cin >> selec;
    if(selec == 1) 
        allDay = true;
    cout << "Inserisci la data di inizio:\n";
    sDate = getDate();
    cout << "Inserisci 1 se l'evento termina entro il giorno inserito\n(Se la data di inizio e' la stessa della fine):\t";
    cin >> singleDay;
    if(singleDay == 1)
        singD = true;
    if(!allDay){
        cout << "Inserisci l'orario di inizio:\n";
        sTime = getTime();
        cout << "Inserisci l'orario di fine:\n";
        eTime = getTime();
    }else {
        sTime = {0,0,0,true};
        eTime = {0,0,0,true};
    }
    if(!singD){
        cout << "Inserisci la data di fine:\n";
        eDate = getDate();
    }else {
        eDate = sDate;
        cin.ignore();
    }
    cout << "Inserisci una descrizione per l'evento:\n";
    getline(cin, desc);
    cout << "Inserisci la location dell'evento:\n";
    getline(cin, loc);
    return allToString(subject,desc,loc,allDay,sTime,eTime,sDate,eDate);
}

string getData(string subject, string desc, string loc){
    int selec, singleDay;
    bool allDay = false, singD = false;
    Orario sTime, eTime;
    Data sDate, eDate;
    cout << "Inserire 1 per segnare tutto il giorno:\t";
    cin >> selec;
    if(selec == 1) 
        allDay = true;
    cout << "Inserisci la data di inizio:\n";
    sDate = getDate();
    cout << "Inserisci 1 se l'evento termina entro il giorno inserito\n(Se la data di inizio e' la stessa della fine):\t";
    cin >> singleDay;
    if(singleDay == 1)
        singD = true;
    if(!allDay){
        cout << "Inserisci l'orario di inizio:\n";
        sTime = getTime();
        cout << "Inserisci l'orario di fine:\n";
        eTime = getTime();
    }else {
        sTime = {0,0,0,true};
        eTime = {0,0,0,true};
    }
    if(!singD){
        cout << "Inserisci la data di fine:\n";
        eDate = getDate();
    }else {
        eDate = sDate;
    }
    return allToString(subject,desc,loc,allDay,sTime,eTime,sDate,eDate);
}

string getData(string subject, string desc, string loc, bool allDay, Orario sTime, Orario eTime){
    Data sDate, eDate;
    bool singD = false;
    int singleDay;
    cout << "Inserisci la data di inizio:\n";
    sDate = getDate();
    cout << "Inserisci 1 se l'evento termina entro il giorno inserito\n(Se la data di inizio e' la stessa della fine):\t";
    cin >> singleDay;
    if(singleDay == 1)
        singD = true;
    if(!singD){
        cout << "Inserisci la data di fine:\n";
        eDate = getDate();
    }else {
        eDate = sDate;
    }
    return allToString(subject,desc,loc,allDay,sTime,eTime,sDate,eDate);
}

void fill(string file, string line){
    ofstream dats(file, ios::app);
    dats << "\n" << line;
    dats.close();
}

void menu(){
    int selec;
    string file, base = "Subject,Start Date,Start Time,End Date,End Time,All Day Event,Description,Location";
    cout << "Inserire il nome che si vuole dare al file:\n";
    cin >> file;
    file += ".csv";
    ofstream dats(file);
    dats << base;
    dats.close();
    do{
        cout << "1) Inserisci un evento al completo:\n";
        cout << "2) Inserisci piu' eventi con solo le date e orari diversi:\n";
        cout << "3) Inserisci piu' eventi con solo le date diverse:\n";
        cout << "4) Per uscire:\n";
        cin >> selec;
        cin.ignore();
        int x, y; 
        string desc, loc, subject; 
        bool allDay; 
        Orario sTime, eTime;
        switch(selec){
            case 1: fill(file, getData());break;
            case 2:
            cout << "Inserisci il soggetto dell'evento :\n";
            getline(cin, subject);
            cout << "Inserisci una descrizione per l'evento:\n";
            getline(cin, desc);
            cout << "Inserisci la location dell'evento:\n";
            getline(cin, loc);
            do{
                fill(file, getData(subject, desc, loc));
                cout << "Inserisci 1 per continuare ad aggiungere eventi:\t";
                cin >> x;
            }while(x == 1);break;
            case 3:
            cout << "Inserisci il soggetto dell'evento :\n";
            getline(cin, subject);
            cout << "Inserire 1 per segnare tutto il giorno:\t";
            cin >> y;
            if(y == 1) 
                allDay = true;
            else
                allDay = false;
            if(!allDay){
                cout << "Inserisci l'orario di inizio:\n";
                sTime = getTime();
                cout << "Inserisci l'orario di fine:\n";
                eTime = getTime();
            }else{
                sTime = {0,0,0,true};
                eTime = {0,0,0,true};
            }
            cin.ignore();
            cout << "Inserisci una descrizione per l'evento:\n";
            getline(cin, desc);
            cout << "Inserisci la location dell'evento:\n";
            getline(cin, loc);
            do{
                fill(file, getData(subject, desc, loc, allDay, sTime, eTime));
                cout << "Inserisci 1 per continuare ad aggiungere eventi:\t";
                cin >> x;
            }while(x == 1);break;
        }
    } while(selec != 4);
}

int main(void){
    menu();
}