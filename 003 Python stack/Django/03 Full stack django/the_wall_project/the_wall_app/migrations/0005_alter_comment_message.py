# Generated by Django 4.0.2 on 2022-02-16 12:00

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('the_wall_app', '0004_rename_messages_message_rename_message_message_post'),
    ]

    operations = [
        migrations.AlterField(
            model_name='comment',
            name='message',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='comments_message', to='the_wall_app.message'),
        ),
    ]