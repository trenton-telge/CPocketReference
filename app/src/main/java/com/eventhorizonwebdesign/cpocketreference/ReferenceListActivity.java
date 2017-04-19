package com.eventhorizonwebdesign.cpocketreference;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.eventhorizonwebdesign.cpocketreference.adapters.ReferenceListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReferenceListActivity extends AppCompatActivity {

    ReferenceListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String[]>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference_list);
        expListView =(ExpandableListView) findViewById(R.id.ref_list);
        Intent intent = getIntent();
        String t = intent.getStringExtra("t");
        prepareListData(t);
        listAdapter = new ReferenceListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);

    }

    void prepareListData(String t){
        listDataHeader = new ArrayList<>();
        // This is the array that will hold the Strings for all the header titles.
        listDataChild = new HashMap<>();
        // This is the HashMap that will link header strings to their respective list of children
        switch (t) {
            case "iostream":
                listDataHeader.add("Narrow Characters");
                listDataHeader.add("Wide Characters");

                List<String[]> narrowio = new ArrayList<>();
                narrowio.add(new String[]{"cin", "", "Standard input stream"});
                narrowio.add(new String[]{"cout", "", "Standard output stream"});
                narrowio.add(new String[]{"cerr", "", "Standard error output stream"});
                narrowio.add(new String[]{"clog", "", "Standard logging output stream"});

                List<String[]> wideio = new ArrayList<>();
                wideio.add(new String[]{"wcin", "", "Standard input stream (wide)"});
                wideio.add(new String[]{"wcout", "", "Standard output stream (wide)"});
                wideio.add(new String[]{"wcerr", "", "Standard error output stream (wide)"});
                wideio.add(new String[]{"wclog", "", "Standard logging output stream (wide)"});

                listDataChild.put(listDataHeader.get(0), narrowio);
                listDataChild.put(listDataHeader.get(1), wideio);
                break;
            case "fstream":
                listDataHeader.add("Class Templates");
                listDataHeader.add("Narrow Characters");
                listDataHeader.add("Wide Characters");

                List<String[]> templates = new ArrayList<>();
                templates.add(new String[]{"basic_ifstream", "", "Input file stream template"});
                templates.add(new String[]{"basic_ofstream", "", "Output file stream template"});
                templates.add(new String[]{"basic_fstream", "", "File stream template"});
                templates.add(new String[]{"basic_filebuf", "", "File stream buffer template"});

                List<String[]> narrowf = new ArrayList<>();
                narrowf.add(new String[]{"ifstream", "", "Input file stream"});
                narrowf.add(new String[]{"ofstream", "", "Output file stream"});
                narrowf.add(new String[]{"fstream", "", "Input/Output file stream"});
                narrowf.add(new String[]{"filebuf", "", "File stream buffer"});

                List<String[]> widef = new ArrayList<>();
                widef.add(new String[]{"wifstream", "", "Input file stream (wide)"});
                widef.add(new String[]{"wofstream", "", "Output file stream (wide)"});
                widef.add(new String[]{"wfstream", "", "Input/Output file stream (wide)"});
                widef.add(new String[]{"wfilebuf", "", "File stream buffer (wide)"});

                listDataChild.put(listDataHeader.get(0), templates);
                listDataChild.put(listDataHeader.get(1), narrowf);
                listDataChild.put(listDataHeader.get(2), widef);
                break;
            case "iomanip":
                listDataHeader.add("IO Manipulators");

                List<String[]> manipulators = new ArrayList<>();
                manipulators.add(new String[]{"setiosflags", "[Mask]", "Set specified format flags"});
                manipulators.add(new String[]{"resetiosflags", "[Mask]", "Reset specified format flags"});
                manipulators.add(new String[]{"setbase", "[Base]", "Set basefield flag"});
                manipulators.add(new String[]{"setfill", "[char]", "Set fill character"});
                manipulators.add(new String[]{"setprecision", "[int]", "Set decimal precision"});
                manipulators.add(new String[]{"setw", "[int]", "Set field width"});
                manipulators.add(new String[]{"get_money", "[long double]", "Gets monetary value to argument"});
                manipulators.add(new String[]{"put_money", "[long double]", "Inserts monetary representation of argument"});
                manipulators.add(new String[]{"get_time", "[struct tm][string]", "Gets time value to struct argument"});
                manipulators.add(new String[]{"put_time", "[struct tm][string]", "Inserts time representation of struct argument"});

                listDataChild.put(listDataHeader.get(0), manipulators);
                break;
            case "cmath":
                listDataHeader.add("Trig Functions");
                listDataHeader.add("Hyperbolic Functions");
                listDataHeader.add("Exponential and Log Functions");
                listDataHeader.add("Power Functions");
                listDataHeader.add("Error and Gamma Functions");
                listDataHeader.add("Rounding and Remainder Functions");
                listDataHeader.add("Floating-point Functions");
                listDataHeader.add("Other Functions");
                // TODO listDataHeader.add("Macros");

                List<String[]> trig = new ArrayList<>();
                trig.add(new String[]{"cos", "[double]", "Returns radian cosine of argument"});
                trig.add(new String[]{"sin", "[double]", "Returns radian sine of argument"});
                trig.add(new String[]{"tan", "[double]", "Returns radian tangent of argument"});
                trig.add(new String[]{"acos", "[double]", "Returns radian arc cosine of argument"});
                trig.add(new String[]{"asin", "[double]", "Returns radian arc sine of argument"});
                trig.add(new String[]{"atan", "[double]", "Returns radian arc tangent of argument"});
                trig.add(new String[]{"atan2", "[double][double]", "Returns radian arc tangent of arg2/arg1"});

                List<String[]> hyp = new ArrayList<>();
                hyp.add(new String[]{"cosh", "[double]", "Returns hyperbolic cosine of argument"});
                hyp.add(new String[]{"sinh", "[double]", "Returns hyperbolic sine of argument"});
                hyp.add(new String[]{"tanh", "[double]", "Returns hyperbolic tangent of argument"});
                hyp.add(new String[]{"acosh", "[double]", "Returns hyperbolic arc cosine of argument"});
                hyp.add(new String[]{"asinh", "[double]", "Returns hyperbolic arc sine of argument"});
                hyp.add(new String[]{"atanh", "[double]", "Returns hyperbolic arc tangent of argument"});

                List<String[]> explog = new ArrayList<>();
                explog.add(new String[]{"exp", "[double]", "Returns eˣ"});
                explog.add(new String[]{"frexp", "[double][&double]", "Returns binary significand of arg1"});
                explog.add(new String[]{"ldexp", "[double][double]", "Returns arg1 * 2ᵃʳᵍ²"});
                explog.add(new String[]{"log", "[double]", "Returns natural log of argument"});
                explog.add(new String[]{"log10", "[double]", "Returns common log of argument"});
                explog.add(new String[]{"modf", "[double][&double]", "Returns the fractional part of arg1"});
                explog.add(new String[]{"exp2", "[double]", "Returns 2ˣ"});
                explog.add(new String[]{"expm1", "[double]", "Returns eˣ-1"});
                explog.add(new String[]{"ilogb", "[double]", "Returns the integral part of the logarithm of |x|"});
                explog.add(new String[]{"log1p", "[double]", "Returns the natural log of 1+x"});
                explog.add(new String[]{"logb", "[double]", "Returns the natural log of |x|"});
                explog.add(new String[]{"scalbn", "[double][double]", "Returns arg1 * FLT_RADIXᵃʳᵍ²"});
                explog.add(new String[]{"scalbln", "[long double][long double]", "Returns arg1 * FLT_RADIXᵃʳᵍ²"});

                List<String[]> power = new ArrayList<>();
                power.add(new String[]{"pow", "[double][double]", "Returns arg1ᵃʳᵍ²"});
                power.add(new String[]{"sqrt", "[double]", "Returns the square root of the argument"});
                power.add(new String[]{"cbrt", "[double]", "Returns the cube root of the argument"});
                power.add(new String[]{"hypot", "[double][double]", "Returns the hypotenuse from two given legs"});

                List<String[]> errorgamma = new ArrayList<>();
                errorgamma.add(new String[]{"erf", "[double]", "Returns the error function of x"});
                errorgamma.add(new String[]{"erfc", "[double]", "Returns the complementary error function of x"});
                errorgamma.add(new String[]{"tgamma", "[double]", "Returns the gamma function of x"});
                errorgamma.add(new String[]{"lgamma", "[double]", "Returns log(abs(tgamma(x)))"});

                List<String[]> roundremain = new ArrayList<>();
                roundremain.add(new String[]{"ceil", "[double]", "Rounds the argument upward"});
                roundremain.add(new String[]{"floor", "[double]", "Rounds the argument downward"});
                roundremain.add(new String[]{"fmod", "[double][double]", "Returns the remainder of arg1/arg2"});
                roundremain.add(new String[]{"trunc", "[double]", "Truncates argument to a whole number"});
                roundremain.add(new String[]{"round", "[double]", "Rounds the argument to nearest integer"});
                roundremain.add(new String[]{"lround", "[double]", "Returns rounded long int"});
                roundremain.add(new String[]{"llround", "[double]", "Returns rounded long long int"});
                roundremain.add(new String[]{"rint", "[double]", "Rounds x to an integral value"});
                roundremain.add(new String[]{"lrint", "[double]", "Returns long int rounded to an integral value"});
                roundremain.add(new String[]{"llrint", "[double]", "Returns long long int rounded to an integral value"});
                roundremain.add(new String[]{"nearbyint", "[double]", "Rounds x to an integral value"});
                roundremain.add(new String[]{"remainder", "[double][double]", "Returns rounded remainder of arg1/arg2"});
                roundremain.add(new String[]{"remquo", "[double][double][&int]", "Returns same as remainder() in int arg"});

                List<String[]> floatfunc = new ArrayList<>();
                floatfunc.add(new String[]{"copysign", "[double][double]", "Returns arg1 with sign of arg2"});
                floatfunc.add(new String[]{"nan", "", "Returns NaN double"});
                floatfunc.add(new String[]{"nextafter", "[double][double]", "Returns the next valid value after arg1 near arg2"});
                floatfunc.add(new String[]{"nexttoward", "[double][long double]", "Same as nextafter with a long double arg2"});

                List<String[]> other = new ArrayList<>();
                other.add(new String[]{"fdim", "[double][double]", "Returns positive difference of arguments"});
                other.add(new String[]{"fmax", "[double][double]", "Returns larger of two arguments"});
                other.add(new String[]{"fmin", "[double][double]", "Retuns smaller of two arguments"});
                other.add(new String[]{"fabs", "[double]", "Returns absolute value of argument"});
                other.add(new String[]{"abs", "[double]", "Returns absolute value of argument"});
                other.add(new String[]{"fma", "[double][double][double]", "Returns arg1*arg2+arg3"});

                listDataChild.put(listDataHeader.get(0), trig);
                listDataChild.put(listDataHeader.get(1), hyp);
                listDataChild.put(listDataHeader.get(2), explog);
                listDataChild.put(listDataHeader.get(3), power);
                listDataChild.put(listDataHeader.get(4), errorgamma);
                listDataChild.put(listDataHeader.get(5), roundremain);
                listDataChild.put(listDataHeader.get(6), floatfunc);
                listDataChild.put(listDataHeader.get(7), other);
                break;
            case "ctime":
                listDataHeader.add("Time Manipulation");
                listDataHeader.add("Time Conversion");

                List<String[]> timeManipulation = new ArrayList<>();
                timeManipulation.add(new String[]{"clock", "", "Returns the processor time consumed by the program"});
                timeManipulation.add(new String[]{"difftime", "[time_t][time_t]", "Returns difference of arg1 - arg2"});
                timeManipulation.add(new String[]{"mktime", "[struct]", "Converts argument to a time_t"});
                timeManipulation.add(new String[]{"time", "", "Returns the current calendar time as a value of type time_t"});

                List<String[]> timeConversion = new ArrayList<>();
                timeConversion.add(new String[]{"asctime", "[struct]", "Returns a readable string of the argument time in format Www&nbsp;Mmm&nbsp;dd&nbsp;hh:mm:ss&nbsp;yyyy"});
                timeConversion.add(new String[]{"ctime", "[time_t]", "Returns a readable string of the argument time in format Www&nbsp;Mmm&nbsp;dd&nbsp;hh:mm:ss&nbsp;yyyy"});
                timeConversion.add(new String[]{"gmtime", "[time_t]", "Returns a struct with the values that represent the corresponding time in GMT"});
                timeConversion.add(new String[]{"localtime", "[time_t]", "Returns a struct with the values that represent the corresponding time in the local time zone"});
                timeConversion.add(new String[]{"strftime", "[string][size_t][string][struct]", "Modifies arg1 to represent the time of arg4 with a max size of arg2 in the format specified by arg3"});

                listDataChild.put(listDataHeader.get(0), timeManipulation);
                listDataChild.put(listDataHeader.get(1), timeConversion);
                break;
            case "cctype":
                listDataHeader.add("Character Classification");
                listDataHeader.add("Character Conversion");

                List<String[]> charClass = new ArrayList<>();
                charClass.add(new String[]{"isalnum", "[(int)char]", "Returns true if arg is alphanumeric, false otherwise"});
                charClass.add(new String[]{"isalpha", "[(int)char]", "Returns true if arg is alphabetic, false otherwise"});
                charClass.add(new String[]{"isblank", "[(int)char]", "Returns true if arg is a space or tab, fase otherwise"});
                charClass.add(new String[]{"iscntrl", "[(int)char]", "Returns true if arg is a control character, false otherwise"});
                charClass.add(new String[]{"isdigit", "[(int)char]", "Returns true if arg is a digit, false otherwise"});
                charClass.add(new String[]{"isgraph", "[(int)char]", "Returns true if arg has a grapical representation, false otherwise"});
                charClass.add(new String[]{"islower", "[(int)char]", "Returns true if arg is a lowercase letter, false otherwise"});
                charClass.add(new String[]{"isprint", "[(int)char]", "Returns true if arg is printable, false otherwise"});
                charClass.add(new String[]{"ispunct", "[(int)char]", "Returns true if arg is punctuation, false otherwise"});
                charClass.add(new String[]{"isspace", "[(int)char]", "Returns true of arg is a whitespace character, false otherwise"});
                charClass.add(new String[]{"isupper", "[(int)char]", "Returns true if arg is an uppercase letter, false otherwise"});
                charClass.add(new String[]{"isxdigit", "[(int)char]", "Returns true of arg is a hexadecimal digit, false otherwise"});

                List<String[]> charConv = new ArrayList<>();
                charConv.add(new String[]{"tolower", "[(int)char]", "Returns the lowercase representation of arg"});
                charConv.add(new String[]{"toupper", "[(int)char]", "Returns the uppercase representation of arg"});

                listDataChild.put(listDataHeader.get(0), charClass);
                listDataChild.put(listDataHeader.get(1), charConv);
                break;
            default:

                break;
        }
    }
}
