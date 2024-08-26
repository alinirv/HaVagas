package br.edu.ifsp.scl.ads.pdm.havagas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.ads.pdm.havagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        // Configuração do Spinner (Formacao)
        amb.formacaoSP.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                configurarCamposAdicionais(position)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) { }
        }

        amb.btnSalvar.setOnClickListener {
            val nomeCompleto = amb.nomeCompletoEt.text.toString()
            val email = amb.emailEt.text.toString()
            val telefone = amb.telefoneET.text.toString()
            val sexo = if (amb.masculinoRb.isChecked) "Masculino" else "Feminino"
            val formacao = amb.formacaoSP.selectedItem.toString()
            val anoConclusao = amb.anoConclusaoEt.text.toString()
            val instituicao = amb.instituicaoEt.text.toString()
            val tituloMonografia = amb.tituloMonografiaEt.text.toString()
            val orientador = amb.orientadorEt.text.toString()
            val vagasInteresse = amb.vagasInteresseEt.text.toString()

            val mensagem = StringBuilder()
            mensagem.append("Nome: $nomeCompleto\n")
            mensagem.append("E-mail: $email\n")
            mensagem.append("Telefone: $telefone\n")
            mensagem.append("Sexo: $sexo\n")
            mensagem.append("Formação: $formacao\n")
            if (anoConclusao.isNotEmpty()) mensagem.append("Ano de Conclusão: $anoConclusao\n")
            if (instituicao.isNotEmpty()) mensagem.append("Instituição: $instituicao\n")
            if (tituloMonografia.isNotEmpty()) mensagem.append("Título da Monografia: $tituloMonografia\n")
            if (orientador.isNotEmpty()) mensagem.append("Orientador: $orientador\n")
            mensagem.append("Vagas de interesse: $vagasInteresse")

            Toast.makeText(this, mensagem.toString(), Toast.LENGTH_LONG).show()
        }



    }

    private fun configurarCamposAdicionais(position: Int) {
        amb.anoConclusaoEt.visibility = View.GONE
        amb.instituicaoEt.visibility = View.GONE
        amb.tituloMonografiaEt.visibility = View.GONE
        amb.orientadorEt.visibility = View.GONE

        when (position) {
            1, 2 -> {
                // Fundamental e Médio
                amb.anoConclusaoEt.visibility = View.VISIBLE
                amb.anoConclusaoEt.hint = "Ano de formatura"
            }
            3, 4 -> {
                // Graduação e Especialização
                amb.anoConclusaoEt.visibility = View.VISIBLE
                amb.anoConclusaoEt.hint = "Ano de conclusão"
                amb.instituicaoEt.visibility = View.VISIBLE
            }
            5, 6 -> {
                // Mestrado e Doutorado
                amb.anoConclusaoEt.visibility = View.VISIBLE
                amb.anoConclusaoEt.hint = "Ano de conclusão"
                amb.instituicaoEt.visibility = View.VISIBLE
                amb.tituloMonografiaEt.visibility = View.VISIBLE
                amb.orientadorEt.visibility = View.VISIBLE
            }
        }
    }
}
