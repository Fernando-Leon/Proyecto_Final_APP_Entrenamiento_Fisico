package com.example.entrenamientofisico;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.entrenamientofisico.db.dbinsert;

public class activityExercicios extends AppCompatActivity {

    private LinearLayout linear1;
    private TextView titulo, descripcion, tituloEjercicio, countExercices;
    private Button botonRecorrer, botonRetroceder, salirMain;
    int numEjercicio = 0, countLevel = 0;
    private ImageView imag;
    String nombredelacategoria="";
    int numCategoria = 0;

    String indexTitle[] = {
            "ABDOMINALES - PRINCIPIANTE",
            "ABDOMINALES - INTERMEDIO",
            "ABDOMINALES - AVANZADO",
            "ESPALDA Y HOMBROS - PRINCIPIANTE",
            "ESPALDA Y HOMBROS - INTERMEDIO",
            "ESPALDA Y HOMBROS - AVANZADO",
            "PECHO - PRINCIPIANTE",
            "PECHO - INTERMEDIO",
            "PECHO - AVANZADO",
            "BRAZO - PRINCIPIANTE",
            "BRAZO - INTERMEDIO",
            "BRAZO - AVANZADO",
            "PIERNA - PRINCIPIANTE",
            "PIERNA - INTERMEDIO",
            "PIERNA - AVANZADO"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicios);

        titulo = (TextView) findViewById(R.id.tituloEjercicio);
        tituloEjercicio = (TextView) findViewById(R.id.nombreEjercicio);
        descripcion = (TextView) findViewById(R.id.descripcionEjercicio);
        countExercices = (TextView) findViewById(R.id.repsTime);
        imag = (ImageView) findViewById(R.id.image_ex);
        linear1 = (LinearLayout) findViewById(R.id.linearcontentvalues);

        Bundle getValue = getIntent().getExtras();
        int valueCat = getValue.getInt("value");
        numCategoria = valueCat;

        Uri urls = null;
        urls = Uri.parse("https://media.giphy.com/media/KAN81GTvMstR8rCaEv/giphy.gif");
        Glide.with(getApplicationContext()).load(urls).into(imag);


        String abdominales[][] = {
                {"RUSSIAN TWIST","Para este ejercicio, siéntate en el suelo y agarra con ambas manos la mancuerna y vas a moverla un lado, como si la fueras a llevar hacia atrás de tu espalda, de esta manera tu abdomen y oblicuos trabajan. Repite en cada lado.", "https://media.giphy.com/media/RgRIG7FMlrDvatdy87/giphy.gif", "x8"},
                {"PAPA CALIENTE ","Para este ejercicio elige una pesa que puedas mover de mano a mano, tal vez esta sea una pesa más liviana que la que usaste para los Russian Twists. Pasa la mancuerna o pesa de mano a mano bajándola hasta abajo y enfocando la fuerza de nuestro core para levantarla y pasarla hacia el otro lado. Repte el ejercicio.", "https://media.giphy.com/media/l0NrJ7OvxlvrBPzRtZ/giphy.gif", "x16"},
                {"LEVANTAMIENTO CON MANCUERNAS","Ahora, en este siguiente ejercicio elige dos mancuernas del mismo peso y acuéstate en el suelo. Mantén tus piernas en el suelo y levanta, con la fuerza de tu abdomen, tu cuerpo superior teniendo los brazos arriba con las pesas. Recuerda concentrar toda tu fuerza en tu abdomen.", "https://media.giphy.com/media/Yzk0L7WJ5YE9pA9332/giphy.gif", "x8"},
                {"VUELTA AL MUNDO","Para este siguiente ejercicio, ponte de pie y con ambas manos agarra tu pesa o mancuerna. Haciendo movimientos circulares lleva la mancuerna desde abajo hacia arriba.", "https://media.giphy.com/media/P1dzjL7SILpQNecijc/giphy.gif", "x8"},
                {"HALO","Tomamos nuestra mancuerna o pesa con ambas manos, movemos la pesa alrededor de nuestra cabeza. Repite el ejercicio.", "https://media.giphy.com/media/AMBYi5qv8PfNCKD5Bz/giphy.gif", "x8"},
                {"RUSSIAN SWINGS","Con una mancuerna rusa, mantenemos una posición neutral, flexionando un poco nuestras piernas y llevando la mancuerna desde abajo hacia arriba a 90 grados. Cada vez que subes la mancuerna, tus piernas deben ponerse rectas y cuando la mancuerna regresa, vuelves a flexionar tus piernas un poco.", "https://media.giphy.com/media/KecKsaPHHn1TYbCzpu/giphy.gif", "x8"},
                {"X CROSS","Con ambas manos nuevamente tomaremos nuestra pesa o mancuerna. Aquí el movimiento será diagonal, así que lleva la pesa desde el lado derecho abajo y súbela hacia tu lado izquierdo arriba. Cuando bajas la mancuerna tiene que ser hasta abajo y cuando la subes tiene que ser hasta arriba. Pon tus pies muy firmes y concentra toda tu fuerza en tu abdomen.", "https://media.giphy.com/media/bOTxwO8tUvuQjGCguH/giphy.gif", "x8"},
                {"ABS CURLS","Con ambas manos la vamos a poner detrás de nuestra cabeza. En el momento que te levantas, en un movimiento circular tenemos que llevar la pesa a nuestro abdomen.", "https://media.giphy.com/media/MFUeCr0EajTb2qwRlx/giphy.gif", "x8"},
                {"RENEGADE ROWS","Ahora con dos mancuernas, irás a un posición parecida al plank, manteniendo tu abdomen apretado y tu espalda recta.", "https://media.giphy.com/media/8gB0Qt9oyNs3olyspz/giphy.gif", "x8"},
                {"HALO","Tomamos nuestra mancuerna o pesa con ambas manos, movemos la pesa alrededor de nuestra cabeza. Repite el ejercicio.", "https://media.giphy.com/media/AMBYi5qv8PfNCKD5Bz/giphy.gif", "x8"},
                {"DESCANSO", "Terminaeste la ronda de ejercios.\n\nTomate unos minutos para descansar.\n\nRecuerda tomar suficiente agua.", "https://media.giphy.com/media/E5jrFRY38yFo30C4nV/giphy.gif", "10"}
        };

        String espaldaHombros[][] = {
                {"ROMANIAN PULL", "Mantén una posición neutral, espalda recta, flexiones tus piernas un poco y con una mancuerna rusa en cada mano, las levantamos. Cuando levantas las mancuernas estiras tus piernas. Repite el ejercicio.", "https://media.giphy.com/media/QoAO3huLA97YEjTKIW/giphy.gif", "x10"},
                {"SNATCH", "Si eres principiantes puedas hacer la variación de tener ambas mancuernas en tus manos y solo ir levantando los hombros en un gesto de no sé, pero si eres más avanzado harás el movimiento con las pesas llevándolas desde abajo hacia arriba activando tus músculos trapecios. Repite el ejercicio.", "https://media.giphy.com/media/oYFxmu5uAa4LEqiNnC/giphy.gif", "x16"},
                {"ROW", "Nuevamente con las mancuernas rusas. Toma ambas con tus manos,  en la misma posición que estabas para los Romanian pull y solo que ahora mantén la  espalda recta y levantas las pesas con los codos arriba, tratando de llevar las pesas a tus músculos laterales. Repite el ejercicio.", "https://media.giphy.com/media/un5K1qIxxfgNJEzULG/giphy.gif", "x10"},
                {"DOMINADAS ANCHAS", "Tomate de una barra y sube tu cabeza por encima de la barra con la ayuda solo de tus manos, baja lentamente. Repite el ejercicio. (Si no tienes una barra remplaza este ejercicio por flexions anchas).", "https://media.giphy.com/media/ynZowScXhk0kpBikU0/giphy.gif", "x8"},
                {"RUSSIAN SWINGS ", "Con una mancuerna rusa, mantenemos una posición neutral, flexionando un poco nuestras piernas y llevando la mancuerna desde abajo hacia arriba a 90 grados. Cada vez que subes la mancuerna, tus piernas deben ponerse rectas y cuando la mancuerna regresa, vuelves a flexionar tus piernas un poco. Repite el ejercicio.", "https://media.giphy.com/media/pxFSabsAvPXPeqhat9/giphy.gif", "x6"},
                {"ROMANIAN PULL", "Mantén una posición neutral, espalda recta, flexiones tus piernas un poco y con una mancuerna rusa en cada mano, las levantamos. Cuando levantas las mancuernas estiras tus piernas. Repite el ejercicio.", "https://media.giphy.com/media/QoAO3huLA97YEjTKIW/giphy.gif", "x10"},
                {"SNATCH", "Si eres principiantes puedas hacer la variación de tener ambas mancuernas en tus manos y solo ir levantando los hombros en un gesto de no sé, pero si eres más avanzado harás el movimiento con las pesas llevándolas desde abajo hacia arriba activando tus músculos trapecios. Repite el ejercicio.", "https://media.giphy.com/media/oYFxmu5uAa4LEqiNnC/giphy.gif", "x16"},
                {"ROW", "Nuevamente con las mancuernas rusas. Toma ambas con tus manos,  en la misma posición que estabas para los Romanian pull y solo que ahora mantén la  espalda recta y levantas las pesas con los codos arriba, tratando de llevar las pesas a tus músculos laterales. Repite el ejercicio.", "https://media.giphy.com/media/un5K1qIxxfgNJEzULG/giphy.gif", "x10"},
                {"DOMINADAS ANCHAS ", "Tomate de una barra y sube tu cabeza por encima de la barra con la ayuda solo de tus manos, baja lentamente. Repite el ejercicio. (Si no tienes una barra remplaza este ejercicio por flexions anchas).", "https://media.giphy.com/media/ynZowScXhk0kpBikU0/giphy.gif", "x8"},
                {"RISSIAN SWINGS ", "Con una mancuerna rusa, mantenemos una posición neutral, flexionando un poco nuestras piernas y llevando la mancuerna desde abajo hacia arriba a 90 grados. Cada vez que subes la mancuerna, tus piernas deben ponerse rectas y cuando la mancuerna regresa, vuelves a flexionar tus piernas un poco. Repite el ejercicio.", "https://media.giphy.com/media/pxFSabsAvPXPeqhat9/giphy.gif", "x6"},
                {"DESCANSO", "Terminaeste la ronda de ejercios.\n\nTomate unos minutos para descansar.\n\nRecuerda tomar suficiente agua.", "https://media.giphy.com/media/E5jrFRY38yFo30C4nV/giphy.gif", "10"}
        };

        String pecho[][] = {
                {"FLEXIONES DIAMANTE", "Comienza en posición para hacer flexiones. Luego crea una forma de diamante debajo del pecho juntando los dedos índices y pulgares y luego presiona el cuerpo arriba y abajo. Recuerda mantener el torso en línea recta.", "https://media.giphy.com/media/YulWkCECzx2wepiBnB/giphy.gif", "x10"},
                {"FLEXIONES SPIDERMAN", "Comienza en la posición habitual para flexiones. Mientras presionas el torso hacia abajo, flexiona y eleva la pierna hacia un lateral. Vuelve a la posición de inicio y repite cambiando de lado. Recuerda mantener el torso en línea recta.", "https://media.giphy.com/media/cZnpBHNo3qHZ7f8B3T/giphy.gif", "x16"},
                {"FLEXIONES CON APLAUSOS", "Comienza en posición de flexiones normales, a la hora de subir genera una explosividad hacia arriba con tus manos intentando dar un aplauso en el aire (si no lo puedes hacer basta con despegar un poco tus manos del suelo). Repite el ejercicio. ", "https://media.giphy.com/media/aD9gfem77qrgKJy1NS/giphy.gif", "x6"},
                {"FLEXIONES ANCHAS", "Ponte en posición de flexiones normales, solo que abra más la distancia que hay entre tus manos. Repite el ejercicio.", "https://media.giphy.com/media/g0VHMlVageDN2g8w8e/giphy.gif", "x10"},
                {"FLEXIONES CON PUÑO", "Ponte en posición de flexiones normales, eectua las flexiones normales solo que ahora apoyate de tus puños en lugar de tus palmas. Repite el ejercicio.", "https://media.giphy.com/media/NTRgOzorvqQrERHcnq/giphy.gif", "x8"},
                {"FLEXIONES DIAMANTE", "Comienza en posición para hacer flexiones. Luego crea una forma de diamante debajo del pecho juntando los dedos índices y pulgares y luego presiona el cuerpo arriba y abajo. Recuerda mantener el torso en línea recta.", "https://media.giphy.com/media/YulWkCECzx2wepiBnB/giphy.gif", "x10"},
                {"FLEXIONES SPIDERMAN", "Comienza en la posición habitual para flexiones. Mientras presionas el torso hacia abajo, flexiona y eleva la pierna hacia un lateral. Vuelve a la posición de inicio y repite cambiando de lado. Recuerda mantener el torso en línea recta.", "https://media.giphy.com/media/cZnpBHNo3qHZ7f8B3T/giphy.gif", "x16"},
                {"FLEXIONES CON APLAUSOS", "Comienza en posición de flexiones normales, a la hora de subir genera una explosividad hacia arriba con tus manos intentando dar un aplauso en el aire (si no lo puedes hacer basta con despegar un poco tus manos del suelo). Repite el ejercicio. ", "https://media.giphy.com/media/aD9gfem77qrgKJy1NS/giphy.gif", "x6"},
                {"FLEXIONES ANCHAS", "Ponte en posición de flexiones normales, solo que abra más la distancia que hay entre tus manos. Repite el ejercicio.", "https://media.giphy.com/media/g0VHMlVageDN2g8w8e/giphy.gif", "x10"},
                {"FLEXIONES CON PUÑO", "Ponte en posición de flexiones normales, eectua las flexiones normales solo que ahora apoyate de tus puños en lugar de tus palmas. Repite el ejercicio.", "https://media.giphy.com/media/NTRgOzorvqQrERHcnq/giphy.gif", "x8"},
                {"DESCANSO", "Terminaeste la ronda de ejercios.\n\nTomate unos minutos para descansar.\n\nRecuerda tomar suficiente agua.", "https://media.giphy.com/media/E5jrFRY38yFo30C4nV/giphy.gif", "10"}
        };

        String brazo[][] = {
                {"FLEXIONES PROFUNDAS", "Bajaremos los brazos hasta tocar con el pecho en el suelo, dejando una breve pausa para evitar rebotar en el suelo y aprovecharnos de ello para subir más fácilmente. Sube lentamente y repite el ejercicio.", "https://media.giphy.com/media/LmdQ9nY1iNWgLsNeDl/giphy.gif", "x8"},
                {"BICEP CURL", "Para hacerlo debemos contar con dos pesa o algún otro objeto, pegamos los codos a los costados de nuestro cuerpo y subimos los brazos flexionándolos lentamente hasta llegar a un angulo mayor a 90 grados. Repite el ejercicio.", "https://media.giphy.com/media/cLAVaOCDj5NffAvbpc/giphy.gif", "x16"},
                {"PIKE PUSH UPS", "Con las manos apoyadas en el suelo y los pies en una superficie mayor a la del suelo, arqueamos un poco nuestra columna, después hacemos flexiones en esta posición subiendo y bajando lentemente. Repite el ejercicio.", "https://media.giphy.com/media/inFRGnivIE9GBwIjm0/giphy.gif", "x6"},
                {"PUSH UPS", "Colocándose boca abajo, con el cuerpo en línea recta. Flexiona los brazos a un ángulo menor a 90 grados, después espera un segundo abajo y sube lentamente. Repite el ejercicio.", "https://media.giphy.com/media/yr6blkQYolfByuft9D/giphy.gif", "x8"},
                {"CLAP PUSH UPS", "Comienza en posición de flexiones normales, a la hora de subir genera una explosividad hacia arriba con tus manos intentando dar un aplauso en el aire (si no lo puedes hacer basta con despegar un poco tus manos del suelo). Repite el ejercicio.", "https://media.giphy.com/media/GuUHOUEHuw94XpeTEU/giphy.gif", "x5"},
                {"FLEXIONES PROFUNDAS ", "Bajaremos los brazos hasta tocar con el pecho en el suelo, dejando una breve pausa para evitar rebotar en el suelo y aprovecharnos de ello para subir más fácilmente. Sube lentamente y repite el ejercicio.", "https://media.giphy.com/media/LmdQ9nY1iNWgLsNeDl/giphy.gif", "x8"},
                {"BICEP CURL", "Para hacerlo debemos contar con dos pesa o algún otro objeto, pegamos los codos a los costados de nuestro cuerpo y subimos los brazos flexionándolos lentamente hasta llegar a un angulo mayor a 90 grados. Repite el ejercicio.", "https://media.giphy.com/media/cLAVaOCDj5NffAvbpc/giphy.gif", "x16"},
                {"PIKE PUSH UPS", "Con las manos apoyadas en el suelo y los pies en una superficie mayor a la del suelo, arqueamos un poco nuestra columna, después hacemos flexiones en esta posición subiendo y bajando lentemente. Repite el ejercicio.", "https://media.giphy.com/media/inFRGnivIE9GBwIjm0/giphy.gif", "x6"},
                {"PUSH UPS", "Colocándose boca abajo, con el cuerpo en línea recta. Flexiona los brazos a un ángulo menor a 90 grados, después espera un segundo abajo y sube lentamente. Repite el ejercicio.", "https://media.giphy.com/media/yr6blkQYolfByuft9D/giphy.gif", "x8"},
                {"CLAP PUSH UPS", "Comienza en posición de flexiones normales, a la hora de subir genera una explosividad hacia arriba con tus manos intentando dar un aplauso en el aire (si no lo puedes hacer basta con despegar un poco tus manos del suelo). Repite el ejercicio.", "https://media.giphy.com/media/GuUHOUEHuw94XpeTEU/giphy.gif", "x5"},
                {"DESCANSO", "Terminaeste la ronda de ejercios.\n\nTomate unos minutos para descansar.\n\nRecuerda tomar suficiente agua.", "https://media.giphy.com/media/E5jrFRY38yFo30C4nV/giphy.gif", "10"}
        };

        String pierna[][] = {
                {"SALTOS EXPLOSIVOS DE RODILLAS", "Ponte de rodillas, con ayuda de tus piernas genera explosividad para ponerte de pie. Repite el ejercicio.", "https://media4.giphy.com/media/XKHiFqVMvCCpnvkaMf/giphy.gif", "x6"},
                {"PISTOL SQUATS", "Comience de pie con los pies separados al ancho de los hombros. Póngase en cuclillas sobre ambas piernas hasta que esté lo más bajo que pueda sostener, luego levante un pie del suelo. Luego, regresa a la posición inicial. Repita el ejercicio en ambas piernas.", "https://media4.giphy.com/media/LTWejllpSno2fVvxqO/giphy.gif", "x5"},
                {"CAMINATA DE PATO", "Ponte en posición de sentadilla profunda, separa los pies poco más allá del ancho de la cadera y descendemos glúteos siempre con espalda recta hasta que nuestras rodillas formen un ángulo inferior a los 90°. Inicia el desplazamiento despegando y adelantando un pie hasta que los muslos queden paralelos al suelo.", "https://media4.giphy.com/media/ikAi8zVbeTa1NHlTOk/giphy.gif", "10m"},
                {"SALTOS EXPLOSIVOS DE PIE", "Ponte de pie, salta lo más alto que puedas intentando tocar tus rodillas con tus pectorales. Repite el ejercicio", "https://media0.giphy.com/media/xjXqSc7yoSj9h76DAe/giphy.gif", "x10"},
                {"INCLINACIONES HACIA ADELANTE", "Sujétate de algún objeto con una  mano, inclínate hacia adelante flexionando las rodillas pero sin llegar a tocar el suelo. Repite el ejercicio.", "https://media3.giphy.com/media/O2WI1FvPAjGtgiiORv/giphy.gif", "x8"},
                {"ZANCADAS LATERALES", "Colócate de pie, con los pies paralelo, desplazar una pierna hacia el lateral y apoyar completamente el pie en el piso mientras flexionamos la rodilla y descendemos el cuerpo. Repite hacia el otro lado.", "https://media4.giphy.com/media/ORp0Y4ZrJo4PAdrGv2/giphy.gif", "x4"},
                {"CAMINATA DE PATO", "Ponte en posición de sentadilla profunda, separa los pies poco más allá del ancho de la cadera y descendemos glúteos siempre con espalda recta hasta que nuestras rodillas formen un ángulo inferior a los 90°. Inicia el desplazamiento despegando y adelantando un pie hasta que los muslos queden paralelos al suelo.", "https://media4.giphy.com/media/ikAi8zVbeTa1NHlTOk/giphy.gif", "10m"},
                {"WALL SIT", "Apóyate contra la pared con los pies firmemente plantados en el suelo, separados al ancho de los hombros. Simula estar sentado recargando tu espalda pon la pared formando un ángulo de recto. Levanta un pie a la altura de la otra rodilla mantenla por un tiempo. Repite en ambas piernas.",  "https://media4.giphy.com/media/ekku6uBiagwDh1iY8g/giphy.gif", "5s"},
                {"SENTADILLAS EXPLOSIVAS PROFUNDAS", "Comienzan con los pies por fuera de las caderas y las rodillas en la misma dirección que las puntas de los pies. Luego echamos la cadera hacia atrás y flexionamos las caderas en 90 grados, saltamos en vertical con toda nuestra energía. Repite el ejercicio.", "https://media.giphy.com/media/XKHiFqVMvCCpnvkaMf/giphy.gif", "x10"},
                {"SALTOS EXPLOSIVOS DE PIE", "Ponte de pie, salta lo más alto que puedas intentando tocar tus rodillas con tus pectorales. Repite el ejercicio", "https://media0.giphy.com/media/xjXqSc7yoSj9h76DAe/giphy.gif", "x10"},
                {"DESCANSO", "Terminaeste la ronda de ejercios.\n\nTomate unos minutos para descansar.\n\nRecuerda tomar suficiente agua.", "https://media.giphy.com/media/E5jrFRY38yFo30C4nV/giphy.gif", "10"}
        };


        int principiante = 1;
        int intermedio = 2;
        int avanzado = 3;


        for(int i=1; i<=15; i+=1) {
            if(valueCat == i){
                titulo.setText(indexTitle[i-1]);
                nombredelacategoria = titulo.getText().toString();
            }
        }

        //Salir del ejercicio

        salirMain = (Button) findViewById(R.id.salirToMain);

        salirMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitToMain();
            }
        });

        //Pasar al siguiente ejercicio

        botonRecorrer = (Button) findViewById(R.id.siguiente);

        //Cambio de estado boton

        if(numEjercicio == 0 && countLevel == 0){
            botonRecorrer.setText("Iniciar");
        }

        botonRecorrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri urlparse = null;
                linear1.setVisibility(View.VISIBLE);

                botonRecorrer.setText("Siguiente");

                if(numEjercicio > 0){
                    botonRetroceder.setVisibility(View.VISIBLE);
                    linear1.setVisibility(View.VISIBLE);
                }

                if(numEjercicio == 10 || numEjercicio == 0){
                    botonRetroceder.setVisibility(View.INVISIBLE);
                }

                if(numEjercicio == 10){
                    botonRecorrer.setText("Continuar");
                    linear1.setVisibility(View.INVISIBLE);
                }

                if((numEjercicio == 9 && (valueCat == 1 || valueCat == 4 || valueCat == 7 || valueCat == 10 || valueCat == 13)) || numEjercicio == 9 && countLevel == 1 || numEjercicio == 9 && countLevel == 2){
                    botonRecorrer.setText("Finalizar");
                }

                //Abdominales

                if(valueCat == 1){
                    if(numEjercicio < abdominales.length){
                        numEjercicio++;
                        tituloEjercicio.setText(abdominales[numEjercicio-1][0]);
                        descripcion.setText(abdominales[numEjercicio-1][1]);
                        urlparse = Uri.parse(abdominales[numEjercicio-1][2]);
                        countExercices.setText(abdominales[numEjercicio-1][3]);
                    }
                    if(numEjercicio == abdominales.length){
                        countLevel++;
                        if(countLevel == principiante){
                            register();
                        }
                    }
                }

                if(valueCat == 2){
                    if(numEjercicio < abdominales.length){
                        numEjercicio++;
                        tituloEjercicio.setText(abdominales[numEjercicio-1][0]);
                        descripcion.setText(abdominales[numEjercicio-1][1]);
                        urlparse = Uri.parse(abdominales[numEjercicio-1][2]);
                        countExercices.setText(abdominales[numEjercicio-1][3]);
                    }
                    if(numEjercicio == abdominales.length){
                        countLevel++;
                        if (countLevel == intermedio ){
                            register();
                        }else {
                            numEjercicio = 0;
                        }
                    }
                }

                if(valueCat == 3){
                    if(numEjercicio < abdominales.length){
                        numEjercicio++;
                        tituloEjercicio.setText(abdominales[numEjercicio-1][0]);
                        descripcion.setText(abdominales[numEjercicio-1][1]);
                        urlparse = Uri.parse(abdominales[numEjercicio-1][2]);
                        countExercices.setText(abdominales[numEjercicio-1][3]);
                    }
                    if(numEjercicio == abdominales.length){
                        countLevel++;
                        if (countLevel == avanzado ){
                            register();
                        }else {
                            numEjercicio = 0;
                        }
                    }
                }

                //Espalda y hombros

                if(valueCat == 4){
                    if(numEjercicio < espaldaHombros.length){
                        numEjercicio++;
                        tituloEjercicio.setText(espaldaHombros[numEjercicio-1][0]);
                        descripcion.setText(espaldaHombros[numEjercicio-1][1]);
                        urlparse = Uri.parse(espaldaHombros[numEjercicio-1][2]);
                        countExercices.setText(espaldaHombros[numEjercicio-1][3]);
                    }
                    if(numEjercicio == espaldaHombros.length){
                        countLevel++;
                        if(countLevel == principiante){
                            register();
                        }
                    }
                }

                if(valueCat == 5){
                    if(numEjercicio < espaldaHombros.length){
                        numEjercicio++;
                        tituloEjercicio.setText(espaldaHombros[numEjercicio-1][0]);
                        descripcion.setText(espaldaHombros[numEjercicio-1][1]);
                        urlparse = Uri.parse(espaldaHombros[numEjercicio-1][2]);
                        countExercices.setText(espaldaHombros[numEjercicio-1][3]);
                    }
                    if(numEjercicio == espaldaHombros.length){
                        countLevel++;
                        if (countLevel == intermedio ){
                            register();
                        }else {
                            numEjercicio = 0;
                        }
                    }
                }

                if(valueCat == 6){
                    if(numEjercicio < espaldaHombros.length){
                        numEjercicio++;
                        tituloEjercicio.setText(espaldaHombros[numEjercicio-1][0]);
                        descripcion.setText(espaldaHombros[numEjercicio-1][1]);
                        urlparse = Uri.parse(espaldaHombros[numEjercicio-1][2]);
                        countExercices.setText(espaldaHombros[numEjercicio-1][3]);
                    }
                    if(numEjercicio == espaldaHombros.length){
                        countLevel++;
                        if (countLevel == avanzado ){
                            register();
                        }else {
                            numEjercicio = 0;
                        }
                    }
                }

                //Pecho

                if(valueCat == 7){
                    if(numEjercicio < pecho.length){
                        numEjercicio++;
                        tituloEjercicio.setText(pecho[numEjercicio-1][0]);
                        descripcion.setText(pecho[numEjercicio-1][1]);
                        urlparse = Uri.parse(pecho[numEjercicio-1][2]);
                        countExercices.setText(pecho[numEjercicio-1][3]);
                    }
                    if(numEjercicio == pecho.length){
                        countLevel++;
                        if(countLevel == principiante){
                            register();
                        }
                    }
                }

                if(valueCat == 8){
                    if(numEjercicio < pecho.length){
                        numEjercicio++;
                        tituloEjercicio.setText(pecho[numEjercicio-1][0]);
                        descripcion.setText(pecho[numEjercicio-1][1]);
                        urlparse = Uri.parse(pecho[numEjercicio-1][2]);
                        countExercices.setText(pecho[numEjercicio-1][3]);
                    }
                    if(numEjercicio == pecho.length){
                        countLevel++;
                        if (countLevel == intermedio ){
                            register();
                        }else {
                            numEjercicio = 0;
                        }
                    }
                }

                if(valueCat == 9){
                    if(numEjercicio < pecho.length){
                        numEjercicio++;
                        tituloEjercicio.setText(pecho[numEjercicio-1][0]);
                        descripcion.setText(pecho[numEjercicio-1][1]);
                        urlparse = Uri.parse(pecho[numEjercicio-1][2]);
                        countExercices.setText(pecho[numEjercicio-1][3]);
                    }
                    if(numEjercicio == pecho.length){
                        countLevel++;
                        if (countLevel == avanzado ){
                            register();
                        }else {
                            numEjercicio = 0;
                        }
                    }
                }

                //Brazo

                if(valueCat == 10){
                    if(numEjercicio < brazo.length){
                        numEjercicio++;
                        tituloEjercicio.setText(brazo[numEjercicio-1][0]);
                        descripcion.setText(brazo[numEjercicio-1][1]);
                        urlparse = Uri.parse(brazo[numEjercicio-1][2]);
                        countExercices.setText(brazo[numEjercicio-1][3]);
                    }
                    if(numEjercicio == brazo.length){
                        countLevel++;
                        if(countLevel == principiante){
                            register();
                        }
                    }
                }

                if(valueCat == 11){
                    if(numEjercicio < brazo.length){
                        numEjercicio++;
                        tituloEjercicio.setText(brazo[numEjercicio-1][0]);
                        descripcion.setText(brazo[numEjercicio-1][1]);
                        urlparse = Uri.parse(brazo[numEjercicio-1][2]);
                        countExercices.setText(brazo[numEjercicio-1][3]);
                    }
                    if(numEjercicio == brazo.length){
                        countLevel++;
                        if (countLevel == intermedio ){
                            register();
                        }else {
                            numEjercicio = 0;
                        }
                    }
                }

                if(valueCat == 12){
                    if(numEjercicio < brazo.length){
                        numEjercicio++;
                        tituloEjercicio.setText(brazo[numEjercicio-1][0]);
                        descripcion.setText(brazo[numEjercicio-1][1]);
                        urlparse = Uri.parse(brazo[numEjercicio-1][2]);
                        countExercices.setText(brazo[numEjercicio-1][3]);
                    }
                    if(numEjercicio == brazo.length){
                        countLevel++;
                        if (countLevel == avanzado ){
                            register();
                        }else {
                            numEjercicio = 0;
                        }
                    }
                }

                //Pierna

                if(valueCat == 13){
                    if(numEjercicio < pierna.length){
                        numEjercicio++;
                        tituloEjercicio.setText(pierna[numEjercicio-1][0]);
                        descripcion.setText(pierna[numEjercicio-1][1]);
                        urlparse = Uri.parse(pierna[numEjercicio-1][2]);
                        countExercices.setText(pierna[numEjercicio-1][3]);
                    }
                    if(numEjercicio == pierna.length){
                        countLevel++;
                        if(countLevel == principiante){
                            register();
                        }
                    }
                }

                if(valueCat == 14){
                    if(numEjercicio < pierna.length){
                        numEjercicio++;
                        tituloEjercicio.setText(pierna[numEjercicio-1][0]);
                        descripcion.setText(pierna[numEjercicio-1][1]);
                        urlparse = Uri.parse(pierna[numEjercicio-1][2]);
                        countExercices.setText(pierna[numEjercicio-1][3]);

                    }
                    if(numEjercicio == pierna.length){
                        countLevel++;
                        if (countLevel == intermedio ){
                            register();
                        }else {
                            numEjercicio = 0;
                        }
                    }
                }

                if(valueCat == 15){
                    if(numEjercicio < pierna.length){
                        numEjercicio++;
                        tituloEjercicio.setText(pierna[numEjercicio-1][0]);
                        descripcion.setText(pierna[numEjercicio-1][1]);
                        urlparse = Uri.parse(pierna[numEjercicio-1][2]);
                        countExercices.setText(pierna[numEjercicio-1][3]);
                    }
                    if(numEjercicio == pierna.length){
                        countLevel++;
                        if (countLevel == avanzado ){
                            register();
                        }else {
                            numEjercicio = 0;
                        }
                    }
                }
                Glide.with(getApplicationContext()).load(urlparse).into(imag);
            }
        });

        //Retroceder ejercicio

        botonRetroceder = (Button) findViewById(R.id.atras);

        if(numEjercicio == 0 && countLevel == 0){
            botonRetroceder.setVisibility(View.INVISIBLE);
        }

        botonRetroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri urlparse = null;


                if(numEjercicio == 1){
                    botonRecorrer.setVisibility(View.INVISIBLE);
                }

                if(numEjercicio > 1){

                    //Abdominales

                    if(valueCat == 1){
                        numEjercicio--;
                        tituloEjercicio.setText(abdominales[numEjercicio-1][0]);
                        descripcion.setText(abdominales[numEjercicio-1][1]);
                        urlparse = Uri.parse(abdominales[numEjercicio-1][2]);
                        countExercices.setText(abdominales[numEjercicio-1][3]);
                    }

                    //Hombros espalda

                    if(valueCat == 4){
                        numEjercicio--;
                        tituloEjercicio.setText(espaldaHombros[numEjercicio-1][0]);
                        descripcion.setText(espaldaHombros[numEjercicio-1][1]);
                        urlparse = Uri.parse(espaldaHombros[numEjercicio-1][2]);
                        countExercices.setText(espaldaHombros[numEjercicio-1][3]);

                    }

                    //Pecho

                    if(valueCat == 7){
                        numEjercicio--;
                        tituloEjercicio.setText(pecho[numEjercicio-1][0]);
                        descripcion.setText(pecho[numEjercicio-1][1]);
                        urlparse = Uri.parse(pecho[numEjercicio-1][2]);
                        countExercices.setText(pecho[numEjercicio-1][3]);
                    }

                    //Brazo

                    if(valueCat == 10){
                        numEjercicio--;
                        tituloEjercicio.setText(brazo[numEjercicio-1][0]);
                        descripcion.setText(brazo[numEjercicio-1][1]);
                        urlparse = Uri.parse(brazo[numEjercicio-1][2]);
                        countExercices.setText(brazo[numEjercicio-1][3]);
                    }

                    //Pierna

                    if(valueCat == 13){
                        numEjercicio--;
                        tituloEjercicio.setText(pierna[numEjercicio-1][0]);
                        descripcion.setText(pierna[numEjercicio-1][1]);
                        urlparse = Uri.parse(pierna[numEjercicio-1][2]);
                        countExercices.setText(pierna[numEjercicio-1][3]);
                    }
                }

                //Abdominales

                if(valueCat == 2){

                    if(countLevel != intermedio && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(abdominales[numEjercicio-1][0]);
                        descripcion.setText(abdominales[numEjercicio-1][1]);
                        urlparse = Uri.parse(abdominales[numEjercicio-1][2]);
                        countExercices.setText(abdominales[numEjercicio-1][3]);
                    }else if(countLevel == intermedio && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(abdominales[numEjercicio-1][0]);
                        descripcion.setText(abdominales[numEjercicio-1][1]);
                        urlparse = Uri.parse(abdominales[numEjercicio-1][2]);
                        countExercices.setText(abdominales[numEjercicio-1][3]);
                    }else if(countLevel == intermedio && numEjercicio == 0){
                        numEjercicio = abdominales.length;
                        countLevel--;
                        tituloEjercicio.setText(abdominales[numEjercicio-1][0]);
                        descripcion.setText(abdominales[numEjercicio-1][1]);
                        urlparse = Uri.parse(abdominales[numEjercicio-1][2]);
                        countExercices.setText(abdominales[numEjercicio-1][3]);
                    }
                }

                if(valueCat == 3){

                    if(countLevel != avanzado && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(abdominales[numEjercicio-1][0]);
                        descripcion.setText(abdominales[numEjercicio-1][1]);
                        urlparse = Uri.parse(abdominales[numEjercicio-1][2]);
                        countExercices.setText(abdominales[numEjercicio-1][3]);
                    }else if(countLevel == avanzado && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(abdominales[numEjercicio-1][0]);
                        descripcion.setText(abdominales[numEjercicio-1][1]);
                        urlparse = Uri.parse(abdominales[numEjercicio-1][2]);
                        countExercices.setText(abdominales[numEjercicio-1][3]);
                    }else if(countLevel == avanzado && numEjercicio == 0){
                        numEjercicio = abdominales.length;
                        countLevel--;
                        tituloEjercicio.setText(abdominales[numEjercicio-1][0]);
                        descripcion.setText(abdominales[numEjercicio-1][1]);
                        urlparse = Uri.parse(abdominales[numEjercicio-1][2]);
                        countExercices.setText(abdominales[numEjercicio-1][3]);
                    }
                }

                //Hombros y espalda

                if(valueCat == 5){

                    if(countLevel != intermedio && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(espaldaHombros[numEjercicio-1][0]);
                        descripcion.setText(espaldaHombros[numEjercicio-1][1]);
                        urlparse = Uri.parse(espaldaHombros[numEjercicio-1][2]);
                        countExercices.setText(espaldaHombros[numEjercicio-1][3]);
                    }else if(countLevel == intermedio && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(espaldaHombros[numEjercicio-1][0]);
                        descripcion.setText(espaldaHombros[numEjercicio-1][1]);
                        urlparse = Uri.parse(espaldaHombros[numEjercicio-1][2]);
                        countExercices.setText(espaldaHombros[numEjercicio-1][3]);
                    }else if(countLevel == intermedio && numEjercicio == 0){
                        numEjercicio = espaldaHombros.length;
                        countLevel--;
                        tituloEjercicio.setText(espaldaHombros[numEjercicio-1][0]);
                        descripcion.setText(espaldaHombros[numEjercicio-1][1]);
                        urlparse = Uri.parse(espaldaHombros[numEjercicio-1][2]);
                        countExercices.setText(espaldaHombros[numEjercicio-1][3]);
                    }
                }

                if(valueCat == 6){

                    if(countLevel != avanzado && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(espaldaHombros[numEjercicio-1][0]);
                        descripcion.setText(espaldaHombros[numEjercicio-1][1]);
                        urlparse = Uri.parse(espaldaHombros[numEjercicio-1][2]);
                        countExercices.setText(espaldaHombros[numEjercicio-1][3]);
                    }else if(countLevel == avanzado && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(espaldaHombros[numEjercicio-1][0]);
                        descripcion.setText(espaldaHombros[numEjercicio-1][1]);
                        urlparse = Uri.parse(espaldaHombros[numEjercicio-1][2]);
                        countExercices.setText(espaldaHombros[numEjercicio-1][3]);
                    }else if(countLevel == avanzado && numEjercicio == 0){
                        numEjercicio = espaldaHombros.length;
                        countLevel--;
                        tituloEjercicio.setText(espaldaHombros[numEjercicio-1][0]);
                        descripcion.setText(espaldaHombros[numEjercicio-1][1]);
                        urlparse = Uri.parse(espaldaHombros[numEjercicio-1][2]);
                        countExercices.setText(espaldaHombros[numEjercicio-1][3]);
                    }
                }

                //Pecho

                if(valueCat == 8){

                    if(countLevel != intermedio && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(pecho[numEjercicio-1][0]);
                        descripcion.setText(pecho[numEjercicio-1][1]);
                        urlparse = Uri.parse(pecho[numEjercicio-1][2]);
                        countExercices.setText(pecho[numEjercicio-1][3]);
                    }else if(countLevel == intermedio && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(pecho[numEjercicio-1][0]);
                        descripcion.setText(pecho[numEjercicio-1][1]);
                        urlparse = Uri.parse(pecho[numEjercicio-1][2]);
                        countExercices.setText(pecho[numEjercicio-1][3]);
                    }else if(countLevel == intermedio && numEjercicio == 0){
                        numEjercicio = pecho.length;
                        countLevel--;
                        tituloEjercicio.setText(pecho[numEjercicio-1][0]);
                        descripcion.setText(pecho[numEjercicio-1][1]);
                        urlparse = Uri.parse(pecho[numEjercicio-1][2]);
                        countExercices.setText(pecho[numEjercicio-1][3]);
                    }
                }

                if(valueCat == 9){

                    if(countLevel != avanzado && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(pecho[numEjercicio-1][0]);
                        descripcion.setText(pecho[numEjercicio-1][1]);
                        urlparse = Uri.parse(pecho[numEjercicio-1][2]);
                        countExercices.setText(pecho[numEjercicio-1][3]);
                    }else if(countLevel == avanzado && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(pecho[numEjercicio-1][0]);
                        descripcion.setText(pecho[numEjercicio-1][1]);
                        urlparse = Uri.parse(pecho[numEjercicio-1][2]);
                        countExercices.setText(pecho[numEjercicio-1][3]);
                    }else if(countLevel == avanzado && numEjercicio == 0){
                        numEjercicio = pecho.length;
                        countLevel--;
                        tituloEjercicio.setText(pecho[numEjercicio-1][0]);
                        descripcion.setText(pecho[numEjercicio-1][1]);
                        urlparse = Uri.parse(pecho[numEjercicio-1][2]);
                        countExercices.setText(pecho[numEjercicio-1][3]);
                    }
                }

                //Brazo

                if(valueCat == 11){

                    if(countLevel != intermedio && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(brazo[numEjercicio-1][0]);
                        descripcion.setText(brazo[numEjercicio-1][1]);
                        urlparse = Uri.parse(brazo[numEjercicio-1][2]);
                        countExercices.setText(brazo[numEjercicio-1][3]);
                    }else if(countLevel == intermedio && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(brazo[numEjercicio-1][0]);
                        descripcion.setText(brazo[numEjercicio-1][1]);
                        urlparse = Uri.parse(brazo[numEjercicio-1][2]);
                        countExercices.setText(brazo[numEjercicio-1][3]);
                    }else if(countLevel == intermedio && numEjercicio == 0){
                        numEjercicio = brazo.length;
                        countLevel--;
                        tituloEjercicio.setText(brazo[numEjercicio-1][0]);
                        descripcion.setText(brazo[numEjercicio-1][1]);
                        urlparse = Uri.parse(brazo[numEjercicio-1][2]);
                        countExercices.setText(brazo[numEjercicio-1][3]);
                    }
                }

                if(valueCat == 12){

                    if(countLevel != avanzado && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(brazo[numEjercicio-1][0]);
                        descripcion.setText(brazo[numEjercicio-1][1]);
                        urlparse = Uri.parse(brazo[numEjercicio-1][2]);
                        countExercices.setText(brazo[numEjercicio-1][3]);
                    }else if(countLevel == avanzado && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(brazo[numEjercicio-1][0]);
                        descripcion.setText(brazo[numEjercicio-1][1]);
                        urlparse = Uri.parse(brazo[numEjercicio-1][2]);
                        countExercices.setText(brazo[numEjercicio-1][3]);
                    }else if(countLevel == avanzado && numEjercicio == 0){
                        numEjercicio = brazo.length;
                        countLevel--;
                        tituloEjercicio.setText(brazo[numEjercicio-1][0]);
                        descripcion.setText(brazo[numEjercicio-1][1]);
                        urlparse = Uri.parse(brazo[numEjercicio-1][2]);
                        countExercices.setText(brazo[numEjercicio-1][3]);
                    }
                }

                //pierna

                if(valueCat == 14){

                    if(countLevel != intermedio && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(pierna[numEjercicio-1][0]);
                        descripcion.setText(pierna[numEjercicio-1][1]);
                        urlparse = Uri.parse(pierna[numEjercicio-1][2]);
                        countExercices.setText(pierna[numEjercicio-1][3]);
                    }else if(countLevel == intermedio && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(pierna[numEjercicio-1][0]);
                        descripcion.setText(pierna[numEjercicio-1][1]);
                        urlparse = Uri.parse(pierna[numEjercicio-1][2]);
                        countExercices.setText(pierna[numEjercicio-1][3]);
                    }else if(countLevel == intermedio && numEjercicio == 0){
                        numEjercicio = pierna.length;
                        countLevel--;
                        tituloEjercicio.setText(pierna[numEjercicio-1][0]);
                        descripcion.setText(pierna[numEjercicio-1][1]);
                        urlparse = Uri.parse(pierna[numEjercicio-1][2]);
                        countExercices.setText(pierna[numEjercicio-1][3]);
                    }
                }

                if(valueCat == 15){

                    if(countLevel != avanzado && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(pierna[numEjercicio-1][0]);
                        descripcion.setText(pierna[numEjercicio-1][1]);
                        urlparse = Uri.parse(pierna[numEjercicio-1][2]);
                        countExercices.setText(pierna[numEjercicio-1][3]);
                    }else if(countLevel == avanzado && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(pierna[numEjercicio-1][0]);
                        descripcion.setText(pierna[numEjercicio-1][1]);
                        urlparse = Uri.parse(pierna[numEjercicio-1][2]);
                        countExercices.setText(pierna[numEjercicio-1][3]);
                    }else if(countLevel == avanzado && numEjercicio == 0){
                        numEjercicio = pierna.length;
                        countLevel--;
                        tituloEjercicio.setText(pierna[numEjercicio-1][0]);
                        descripcion.setText(pierna[numEjercicio-1][1]);
                        urlparse = Uri.parse(pierna[numEjercicio-1][2]);
                        countExercices.setText(pierna[numEjercicio-1][3]);
                    }
                }


                if(numEjercicio == 1){
                    botonRetroceder.setVisibility(View.INVISIBLE);
                }

                botonRecorrer.setText("Siguiente");

                Glide.with(getApplicationContext()).load(urlparse).into(imag);
            }

        });

    }

    private void exitToMain() {
        new AlertDialog.Builder(this)
                .setTitle("Salir al menú principal")
                .setMessage("Desea salir del ejercicio?")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }

    //Metodo para guardar el ejercicio en el historial

    private void register(){

        numEjercicio = 0;
        countLevel = 0;

        Bundle sendValue = new Bundle();
        Intent intent = new Intent(activityExercicios.this, resultados.class);
        intent.putExtra("categorias", nombredelacategoria);
        intent.putExtra("valueData", numCategoria);
        startActivity(intent);
    }

}